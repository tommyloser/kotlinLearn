package net.println.kotlin.Chapter3

fun main(vararg args:String) {
//    for (arg in args) {
//        println(arg)
//    }
    val array = intArrayOf(1,3,4,5)
    val list = arrayListOf(1,3,4,5)//星号不支持list
//    hello(6.0,1,3, 3,4,5, string ="Hello")
    hello(6.0,*array, string ="Hello")//展开数组
    //Spread operator, 不能重载
}

fun hello(double:Double = 3.0, vararg ints: Int,string:String) {
    ints.forEach(::println)
    println(string)
}