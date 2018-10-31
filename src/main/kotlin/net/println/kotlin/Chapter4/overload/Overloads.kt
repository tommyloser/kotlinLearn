package net.println.kotlin.Chapter4.overload

import java.util.ArrayList

class Overloads{
//    fun a():Int{
//        return 0
//    }
    @JvmOverloads
    fun a(int:Int = 0):Int{
        return int
    }

//    fun a():String{
//        return "a"
//    }
}

fun main(args: Array<String>) {
    val overloads = Overloads()
    //方法签名不包括返回值
//    val string:String = overloads.a()
//    val int:Int = overloads.a()
//    overloads.a()
    overloads.a(3)

    val integerList = ArrayList<Int>()
    integerList.add(13)
    integerList.add(1)
    integerList.add(3)
    integerList.add(33)
    integerList.add(43)
    integerList.add(4)
    println(integerList)

    integerList.removeAt(4)
    integerList.remove(4)
    println(integerList)
}