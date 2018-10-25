package net.println.kotlin.Chapter3

val FINAL_HELLO_WORLD:String = "HelloWorld"
var helloworld:String = "HelloWorld"

val FINAL_HELLO_CHINA = "HelloChina"//类型推导

fun main(args: Array<String>) {
//    val 不可以变
    helloworld = "world Hello"
    println(FINAL_HELLO_CHINA)
}