package net.println.kotlin.Chapter7.common

import java.text.SimpleDateFormat
import java.util.*

val dataFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = { //方法
    dataFormat.format(Date(System.currentTimeMillis()))
}

//带时间的日志
fun log(msg: String) = println("${now()}  [${Thread.currentThread().name}] $msg")