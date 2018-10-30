package net.println.kotlin.Chapter3

import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.lang.UnsupportedOperationException

fun main(args: Array<String>) {
    while (true) {
        try {
            println("请输入算术，例如：3+4")
            val input = readLine() ?: break
            val split = input.trim().split(" ")
            if (split.size < 3) {
                throw IllegalArgumentException("参数个数不对")
            }
            val arg1 = split[0].toDouble()
            val op = split[1]
            val arg2 = split[2].toDouble()
            println("$arg1 $op $arg2 = ${Operator(op).apply(arg1, arg2)}")

        } catch (e: NumberFormatException) {
            println("您确定输入的是数字吗")
        } catch (e: IllegalArgumentException) {
            println("三个参数， 空格分开")
        } catch (e: Exception) {
            println("未知异常，${e.message}")
        }

        println("再来一发？[Y]")
        val cmd = readLine()
        if (cmd == null || cmd.toLowerCase() != "y") {
            break
        }
    }

    println("感谢您使用我们的计算器")

}

class Operator(op: String){
    val opFun:(left:Double, right:Double) -> Double //lampda表达式
    init {
        opFun = when (op) {
            "+" -> {l,r -> l + r}
            "-" -> {l,r -> l - r}
            "*" -> {l,r -> l * r}
            "/" -> {l,r -> l / r}
            "%" -> {l,r -> l % r}
            else -> {
                throw UnsupportedOperationException("不支持该运算符 $op")
            }

        }
    }

    fun apply(left: Double, right: Double):Double {
        return opFun(left, right)
    }
}