package net.println.kotlin.Chapter9.generics

import java.math.BigDecimal

fun main(args: Array<String>) {
    //out 斜边 泛型的继承关系是 正常的
    val numberList:List<Number> = listOf(1,2,3)

    /**
     * in 逆变的泛型继承关系是反正来的
     */
    val intComparable:Comparable<Int> = object:Comparable<Any>{//in 逆变
        override fun compareTo(other: Any): Int {
            return 0
        }
    }

    /**
     * 不变 是没有继承关系
     */
//    val numberArrayList:MutableList<Number> = mutableListOf<Int>(1,2,4)
//    numberArrayList.add(BigDecimal("123"))//这里有问题，添加BigDecimal到Int 的列表
//    val numberArrayList:MutableList<Int> = mutableListOf<Number>(1,2,4)

}











//class MyList<in E>{
//    fun contains(element: E): Boolean {
//    }
//
//    fun containsAll(elements: Collection<E>): Boolean {
//    }
//
//     fun indexOf(element: E): Int {
//    }
//
//     fun lastIndexOf(element: E): Int {
//    }
//
//     val size: Int
//
//     fun get(index: Int): @UnsafeVariance E {
//    }
//
//     fun isEmpty(): Boolean {
//    }
//
//     fun iterator(): Iterator<E> {
//    }
//
//     fun listIterator(): ListIterator<E> {
//    }
//
//     fun listIterator(index: Int): ListIterator<E> {
//    }
//
//     fun subList(fromIndex: Int, toIndex: Int): List<E> {
//    }
//
//}