package net.println.kotlin.Chapter3

import java.lang.Exception
import java.lang.NumberFormatException

fun main(args: Array<String>) {
    try {
        val arg1 = args[0].toInt()
        val arg2 = args[1].toInt()
        println("$arg1 + $arg2 = ${sum(arg1, arg2)}")

    } catch (e: NumberFormatException) {
        println("您确定输入的是整数吗")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("您确定输入的是连个整数吗")
    } catch (e: Exception) {
        println("程序出现了未知异常， 可能是您的人品太差， ${e.message}")
    }finally {
        println("谢谢您使用我们的加法计算器")
    }

}