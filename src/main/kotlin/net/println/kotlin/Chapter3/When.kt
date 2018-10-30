package net.println.kotlin.Chapter3

fun main(args: Array<String>) {
    val x = 5
    when (x) {
        is Int -> println("Hello $x")
        in 1..100 -> println("$x is in 1..100")
        !in 1..100 -> println("$x is not in 1..100")
        args[0].toInt() -> println("x == args[0]")

    }

    val mode = when{//表达式
        args.isNotEmpty() && args[0] == "1" -> 1
        else -> 0
    }
}