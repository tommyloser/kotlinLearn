package net.println.kotlin.Chapter4.Confilct

interface B{
    fun x():Int = 1 //默认实现，返回1
}

interface C{
    fun x():Int = 0
}

abstract class A{
    open fun x():Int = 5
}

class D(var y:Int = 0):A(),B,C{

//    override fun x():String {
//
//    }
    override fun x(): Int {
        println("call x():Int in D")
        if (y > 0) {
            return y
        }else if (y < -200) {
            return super<B>.x()
        } else if (y < -100) {
            return super<C>.x()
        } else {
            return super<A>.x()
        }
//        return 0
    }
}

fun main(args: Array<String>) {
    println(D(3).x()) //3
    println(D(-10).x())//5 A
    println(D(-100).x())//5 A
    println(D(-1000).x())//1 B

}