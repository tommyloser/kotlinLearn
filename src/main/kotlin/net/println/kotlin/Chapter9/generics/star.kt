package net.println.kotlin.Chapter9.generics

fun main(args: Array<String>) {
    //协变 泛型是* 号
    val list: List<*> = listOf(1, 2)
//    val list: List<Any?> = listOf(1, 2)
    list[1]//变成了Any? 类型

    //逆变
    val comparable:Comparable<*> = object : Comparable<Any>{
//    val comparable:Comparable<Nothing> = object : Comparable<Any>{
        override fun compareTo(other: Any): Int {
            return 0
        }
    }
//    comparable.compareTo()//in 逆变 nothing 是所有类型的子类

    val mutableList: MutableList<*> = mutableListOf(1, 2, 3)
    mutableList[1] //Any
//    mutableList.set(1,Nothing)

//    hello<*>()//泛型实参不能用* 号

//    val h = Hello<*>()

//    val raw = Raw<String>() kotlin一定要传泛型实参
    val raw:Raw<*>? = Raw.getRaw()
}

fun <T> hello() {

}

open class Hello<T>{

}

class Hello2<T>

class SonOfHello:Hello<Hello2<*>>()//这里可以用* 号， 以为泛型实参是Hello<*>