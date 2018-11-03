package net.println.kotlin.Chapter7.common


object HttpError{ //单例模式
    const val HTTP_ERROR_NO_DATA = 999
    const val HTTP_ERROR_UNKNONW = 998
}

data class HttpException(val code:Int):Exception()