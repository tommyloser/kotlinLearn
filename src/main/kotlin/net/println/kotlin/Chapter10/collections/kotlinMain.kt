package net.println.kotlin.Chapter10.collections

fun main(args: Array<String>) {
//    val arrayList = ArrayList<String>()
//    arrayList.add("Hello")
//    arrayList.add("World")
//    arrayList.remove("World")
//    arrayList.removeAt(0)
//    arrayList.forEach(::println)

    //不可变的list
    val list = listOf("Hello", "World")
    //kotlin 的自己map
    val map = mapOf("key" to "value", "2" to "whatever")
//    map.put 不可put
}

object Test{
    val list = listOf(1, 2, 4)
}