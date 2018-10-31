package net.println.kotlin.Chapter4.extend

import java.lang.StringBuilder

fun main(args: Array<String>) {
//    args.isNotEmpty()
//    if (args.isEmpty()) {
//
//    }

    println("abc"*16)
    println("abc".a)
    "abc".b = 8
    println("abc".b)

}

operator fun String.times(int:Int):String{//扩展方法， 加运算符重载
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

val String.a:String
get() = "abc"

var String.b:Int
set(value) {

}
get() = 5