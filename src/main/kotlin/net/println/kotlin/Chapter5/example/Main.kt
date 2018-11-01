package net.println.kotlin.Chapter5.example

import java.io.File

fun main(args: Array<String>) {
    val map = HashMap<Char, Int>()// 字母， 字母个数
    val text = File("build.gradle")
            //不是空字符串就添加
//            .readText().toCharArray().filterNot(Char::isWhitespace).forEach{
//                //该字母的个数
//                val count = map[it]   //it == char map[it] ==int
//                // 为空则第一个
//                if(count == null) map[it] = 1
//                else map[it] = count + 1
//
//            }
            .readText().toCharArray().filterNot(Char::isWhitespace)
            //分组 返回key ,List<element> //即 <a, List<a>>
            .groupBy { it }.map {
                it.key to it.value.size
            }.forEach(::println)

    map.forEach(::println)


}