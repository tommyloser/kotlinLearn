package net.println.kotlin

val string: String = "HelloWorld"
val fromChars: String = String(charArrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'))

fun main(args: Array<String>) {
    println(string == fromChars)//比较字符串
    println(string === fromChars)//比较对象

    println("接下来我们要输出：" + string)

    val arg1:Int = 0
    val arg2:Int = 1
    println("$arg1 + $arg2 = ${arg1+arg2}")

    //hello "trump"
    val sayHello:String = "Hello\"Trump\""
    println(sayHello)
    //$1000
    println("$1000")
    val salary:Int =1000
    println("$$salary")
    println("\$salary")

    val rawString:String = """
        \t
        \n
        $salary //仍然适用
        $ salary
    """.trimIndent()
    println(rawString)
    println(rawString.length)
}