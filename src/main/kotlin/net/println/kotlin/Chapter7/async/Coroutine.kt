package net.println.kotlin.Chapter7.async

import net.println.kotlin.Chapter7.common.HttpError
import net.println.kotlin.Chapter7.common.HttpException
import net.println.kotlin.Chapter7.common.HttpService
import net.println.kotlin.Chapter7.common.log
import net.println.kotlin.Chapter7.ui.LOGO_URL
import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine

fun 我要开始协程了(context:CoroutineContext = EmptyCoroutineContext, block:suspend () -> Unit){
    /*
    传入一个continuation<T>， 他有一个自定义的context
    AsyncContext() 一个Context element 和 continuation interceptor
    这个interceptor 可以拦截continuation 并且篡改它， 变成Ui continuation
     */
    block.startCoroutine(ContextContinuation(context + AsyncContext()))//suspend 才有startCoroutine方法
//    block.startCoroutine(net.println.kotlin.Chapter7.async.BaseContinuation())//suspend 才有startCoroutine方法
//    block.startCoroutine(UiContinuationWrapper(BaseContinuation()))//可以这样做, 但是不能切线程,因为他先返回了图片在执行Ui的resume方法
}

/**
 * T是耗时操作返回的结果
 */
suspend fun <T>我要开始耗时操作了(block:CoroutineContext.() -> T)
    =suspendCoroutine<T> {
    continuation -> //Continuation<ByteArray>
    log("异步任务开始前")
//    val unContinuation = UiContinuationWrapper(continuation)
    AsyncTask{
        try {
            //传入continuation.Context, 即startCoroutine 传进来的
            continuation.resume(block(continuation.context))
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }.execute()
}

/*
suspendCoroutine 是个方法，
它返回方向参数ByteArray, 传入Continuation<T> -> Unit
该方法创建一个Continuation<ByteArray>
把他传给你处理， 完成后
他在帮你返回结果ByteArray

他传的continuation 是从startCoroutine 来的
 */
//suspend fun 我要开始加载图片了(url: String) = suspendCoroutine<ByteArray> {
//    continuation -> //Continuation<ByteArray>
//    log("异步任务开始前")
////    val uiContinuation = UiContinuationWrapper(continuation)
////    val continuation = UiContinuationWrapper(continuation)
//    AsyncTask{
//        try {
//            log("耗时操作， 下载图片")
//            val responseBody = HttpService.service.getLogo(url).execute()
//            if (responseBody.isSuccessful) {
////                val byteArray = responseBody.body()?.byteStream()?.readBytes()?.let(continuation::resume)
//                responseBody.body()?.byteStream()?.readBytes()?.let {
//                    log("AsyncTask 线程")
////                    SwingUtilities.invokeLater{continuation.resume(it) }}//把byteArray 传给resume方法
//                    continuation.resume(it) }//把byteArray 传给resume方法
////                if (byteArray != null) {
////                    continuation.resume(byteArray)
////                }
////                    continuation.resume(byteArray)
//            } else {
//                continuation.resumeWithException(HttpException(responseBody.code()))
//            }
//        } catch (e: Exception) {
//            continuation.resumeWithException(e)
//        }
//    }.execute()
//}

fun 我要开始加载图片了(url: String) :ByteArray {
//    val unContinuation = UiContinuationWrapper(continuation)
    log("耗时操作， 下载图片")
    val responseBody = HttpService.service.getLogo(url).execute()
    if (responseBody.isSuccessful) {
//            responseBody.body()?.byteStream()?.readBytes()?.let { continuation::resume }//把byteArray 传给resume方法
        val byteArray = responseBody.body()?.byteStream()?.readBytes()
        if (byteArray != null) {
            return byteArray
        } else {
            throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
        }
//                    continuation.resume(byteArray)
    } else {
        throw HttpException(responseBody.code())
    }
}
