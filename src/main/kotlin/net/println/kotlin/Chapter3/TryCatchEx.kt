package net.println.kotlin.Chapter3

import java.lang.Exception

fun main(args: Array<String>) {
    val result = try { //也是表达式
        args[0].toInt()/args[1].toInt()
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }
    println(result)
}