package net.println.kotlin.Chapter3

/**
 * const 是编译器常量， 不加则不是， 可以用反射改变
 */
const val FINAL_HELLO_WORLD:String = "HelloWorld"
var helloworld:String = FINAL_HELLO_WORLD

val FINAL_HELLO_CHINA = "HelloChina"//类型推导

fun main(args: Array<String>) {
//    val 不可以变
//    helloworld = "world Hello"
//    println(FINAL_HELLO_CHINA)
//    println("Hello ${args[0]}")
    checkArgs(args)
    val arg1 = args[0].toInt()
    val arg2 = args[1].toInt()
    println("$arg1 + $arg2 = ${sum(arg1,arg2)}")

    println(int2Long(3))//变量， 它的值是函数
}

fun checkArgs(args: Array<String>) {
    if (args.size != 2) {
        printUsage()
        System.exit(-1)//0xff
    }
}

fun printUsage() {
    println("请传入两个整形参数， 例如1 2")
}

fun sum(arg1: Int, arg2: Int):Int {
    return arg1 + arg2
}

//只有一句话可以简化
fun sum2(arg1: Int, arg2: Int) = arg1 + arg2

//使用一个变量赋值一个函数， 就可以不用名字
val int2Long = fun(x:Int):Long{
    return x.toLong()
}
/* 函数也是类， 它和String，int 一样可以赋值，传递, 他本身是一个代码块*/