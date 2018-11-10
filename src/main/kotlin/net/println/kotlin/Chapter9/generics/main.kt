package net.println.kotlin.Chapter9.generics

import java.math.BigDecimal

fun main(args: Array<String>) {
//    val a = 4
//    val b = 3
//    //比较什么就返回什么， 这就是泛型要解决的问题
//    val c = maxOf(a,b)
//    println(c)
    val complex = Complex<Double>(3.0, 4.0)
    val complex2 = Complex(3, 5)
//    println(maxOf(complex, complex2))
    println(complex)
    println(complex2)

//    (1..9).map {  }/
}

data class Complex<T:Number>(val a:T, val b:T){
//    override fun compareTo(other: Complex<T>): Int {
//        return (value() - other.value()).toInt()
//    }

//    fun value():T{
//        return (a*a + b*b)
//    }

    override fun toString(): String {
        return "($a + $b i)"
    }
}

//定义泛型参数， 在方法名前定义， 可以加约束
fun<T:Comparable<T>> maxOf(a:T, b:T):T{
    return if(a < b)b else a
}