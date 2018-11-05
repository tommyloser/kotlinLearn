package net.println.kotlin.Chapter7.common

/**
 * 自定义网络错误
 */
object HttpError{ //单例模式
    const val HTTP_ERROR_NO_DATA = 999 //没有数据
    const val HTTP_ERROR_UNKNONW = 998 //位置错误
}

data class HttpException(val code:Int):Exception()