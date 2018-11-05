package net.println.kotlin.Chapter7.basic

import net.println.kotlin.Chapter7.common.HttpError
import net.println.kotlin.Chapter7.common.HttpException
import net.println.kotlin.Chapter7.common.HttpService
import net.println.kotlin.Chapter7.common.log
import net.println.kotlin.Chapter7.ui.LOGO_URL
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine

fun 我要开始协程了(block:suspend () -> Unit){
    block.startCoroutine(BaseContinuation())//suspend 才有startCoroutine方法
}

/*
suspendCoroutine 是个方法，
它返回方向参数ByteArray, 传入Continuation<T> -> Unit
该方法创建一个Continuation<ByteArray>
把他传给你处理， 完成后
他在帮你返回结果ByteArray
 */
suspend fun 我要开始加载图片了(url: String) = suspendCoroutine<ByteArray> {
    continuation -> //Continuation<ByteArray>
    log("耗时操作， 下载图片")
    try {
        val responseBody = HttpService.service.getLogo(url).execute()
        if (responseBody.isSuccessful) {
//            responseBody.body()?.byteStream()?.readBytes()?.let { continuation::resume }//把byteArray 传给resume方法
            val byteArray = responseBody.body()?.byteStream()?.readBytes()
            if (byteArray!= null)
                continuation.resume(byteArray)
        } else {
            continuation.resumeWithException(HttpException(responseBody.code()))
        }
    } catch (e: Exception) {
        continuation.resumeWithException(e)
    }
}