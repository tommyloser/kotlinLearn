package net.println.kotlin.Chapter5.builtins

import java.io.BufferedReader
import java.io.FileReader


//fun main(args: Array<String>) {
//    val list = listOf(1, 3, 4, 5, 10, 8, 2)
//
////    val newList = ArrayList<Int>()
//
////    list.forEach{
////        val newElement = it * 2 + 3
////        newList.add(newElement)
////    }
//    val newList = list.map {
//        it * 2 + 3
//    }
//
//    val newList2 = list.map(Int::toDouble)
//
////    newList.forEach(::println)
//    newList2.forEach(::println)
//
////    list.map(::println)

    val list = listOf(
            1..20,
            2..5,
            100..322
    )
// 遍历list, 每个element is list again, new List add all the element list
//传入的lambda 表达式,传入一个element（list) 变成一个list
//    val flatList = list.flatMap {intRange ->
//        intRange.map {intElement ->//list.map = list
//            "No.$intElement"
//        }
//    }
    val flatList = list.flatMap {
        it
    }

//    flatList.forEach(::println)
//    println(flatList.reduce{acc, i -> acc + i })

//    (0..6).map(::factorial).reduce { acc, i -> acc + i }
//    println((0..6).map(::factorial).fold(5){ acc, i ->
//        acc + i
//    })
    //初始值
//    println((0..6).map(::factorial).fold(StringBuilder()){ acc, i ->
//                acc.append(i).append(",")
//    })
//    println((0..6).map(::factorial).filter{it % 2 == 1})
//    println((0..6).map(::factorial).filterIndexed { index, i ->
//        index % 2 == 1 })

//    println((0..6).map(::factorial).takeWhile {it %2 == 1 })

//    println((0..6).joinToString(","))
//}

fun main(args: Array<String>) {
//    val person = findPerson()?.let {person ->
//        println(person.name)
//        println(person.age)
//    }
//    println(person?.name)
//    println(person?.age)
    //with 跟apply 相似
    val person = findPerson()?.apply {
        work()
        println(age)
    }
//    val br = BufferedReader(FileReader("hello.txt")).readText()
//    println(br)
    val br = BufferedReader(FileReader("hello.txt")).use {
        var line:String?
        while (true){
            line = it.readLine()?:break
            println(line)
        }
    }


}

/**
 * 1*1*2*3...*n
 */
fun factorial(n: Int):Int {
    if(n == 0) return 1
    return (1..n).reduce{acc, i -> acc * i }
}

data class Person(val name:String, val age:Int){
    fun work(){
        println("$name is working!!!")
    }
}
fun findPerson(): Person? {
    return null
}