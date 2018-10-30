package net.println.kotlin.Chapter3

class X
class A{
//    protected var b = 0//默认实现get set方法 默认是public
//    protected get() { //改写get方法
//        println("some one tries to get b")
//        return field
//    }
//    protected set
////    protected set(value) {
////        println("some one tries to set b")
////        field = value
////    }

    var b = 0 //基本类型 默认值
    lateinit var c:String //延迟初始化
    lateinit var d:X
    val e:X by lazy{//delegate
        println("init Xe")
        X()
    }

    var cc:String? = null
}

fun main(args: Array<String>) {
    println("start")
    val a = A()
    println("init a")
    println(a.b)
    println(a.e)//使用e ，才初始化

    a.d = X()
    println(a.d)
    println(a.c)

    println(a.cc?.length)
}