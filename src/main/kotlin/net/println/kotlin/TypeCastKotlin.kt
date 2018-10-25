package net.println.kotlin

fun main(args: Array<String>) {
    val parent: Parent = Child()
    if (parent is Child) {
        println(parent.name)//智能转换调用子类方法， 因为判断了是child
    }

    val string:String? = "Hello"
//    if(string is String)//判断是String 即不为空
    if(string != null)//同上
        println(string.length)

    val parent2:Parent = Parent()
//    val child:Child? = parent2 as Child//强转失败
    val child:Child? = parent2 as? Child// 安全类型转换
    println(child)
}