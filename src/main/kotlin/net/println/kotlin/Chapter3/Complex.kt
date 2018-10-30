package net.println.kotlin.Chapter3

class Complex(var real: Double, var imaginary: Double){
    operator fun plus(other: Complex):Complex{
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    operator fun plus(other: Int):Complex{
        return Complex(real + other, imaginary )
    }

//    operator fun plus(): Complex {
//
//    }


    operator fun invoke(): Double {
        return Math.hypot(real, imaginary)
    }

    override fun toString(): String {
        return "$real + $imaginary i"
    }
    /**
     * 运算符重载名字一样 ， 带operator, 参数个数一样，参数类型不同
     */
}

class Book{
    infix fun on(any: Any): Boolean {//中缀表达式
        return false
    }
}

class Desk

fun main(args: Array<String>) {
//    val c1 = Complex(3.0, 4.0)
//    val c2 = Complex(2.0, 7.5)
//    println(c1 + c2)
//    println(c1 + 4)
//    println(c1())
    //-name<Name>
    if ("-name" in args) {
        println(args[args.indexOf("-name") + 1])
    }

    if (Book() on Desk()) {//dsl

    }
}