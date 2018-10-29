package net.println.kotlin.Chapter3

/**
 * const 是编译器常量， 不加则不是， 可以用反射改变
 */
const val FINAL_HELLO_WORLD:String = "HelloWorld"
var helloworld:String = FINAL_HELLO_WORLD

val FINAL_HELLO_CHINA = "HelloChina"//类型推导

fun main(args: Array<String>) { //(Array<String>) -> Unit
//    val 不可以变
//    helloworld = "world Hello"
//    println(FINAL_HELLO_CHINA)
//    println("Hello ${args[0]}")
//    checkArgs(args)
//    val arg1 = args[0].toInt()
//    val arg2 = args[1].toInt()
//    println("$arg1 + $arg2 = ${sum(arg1,arg2)}")
//
//    println(int2Long(3))//变量， 它的值是函数
//
//    println(sum3(1,3))
//    sum3.invoke(1,3) == sum3(1,3)

//    for (i in args) {
//        println(i)
//    }

//    args.forEach { print(it) }
//    args.forEach(::print)
    //print函数名 ，传入一个函数， action 类型和print 类型完全一样

//    args.forEach {
//        if(it == "q")return //这里不是函数， return 就返回到了main函数
//        print(it)
//    }
    args.forEach ForEach@{
        if(it == "q")return@ForEach //想要挑出lambda 表达式，使用标签
        print(it)
    }
    println("The End")

    println(sum3)
    println(int2Long)
    println(::printUsage is () -> Unit)//加两个冒号代表对这个函数的引用

    println(::sum)
}

fun checkArgs(args: Array<String>) {
    if (args.size != 2) {
        printUsage()
        System.exit(-1)//0xff
    }
}

fun printUsage() {
    println("请传入两个整形参数， 例如1 2")//(Any?) -> Unit
} //()->Unit

fun sum(arg1: Int, arg2: Int):Int {
    return arg1 + arg2
}

//只有一句话可以简化
fun sum2(arg1: Int, arg2: Int) = arg1 + arg2

//lambda 表达式
/*lambda 表达式的返回值是最后一行*/
val sum3 = {arg1:Int, arg2:Int -> arg1 + arg2}//(int,int) -> int

val printlnHello = {
    println("Hello")
}
// ()->Unit

//使用一个变量赋值一个函数， 就可以不用名字
val int2Long = fun(x:Int):Long{
    return x.toLong()
}//(Int)-> Long
/* 函数也是类， 它和String，int 一样可以赋值，传递, 他本身是一个代码块*/