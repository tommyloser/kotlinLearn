package net.println.kotlin.Chapter5.closure

val string = "HelloWorld"

fun makeFun():() -> Unit {
    var count = 0//函数的作用域没有释放
    return fun(){
        println(++count)
    }
}

fun fibonacci():() -> Long{
    var first = 0L
    var second = 1L
    return fun():Long{
        val result = second
        second += first
        first = second - first
        return result
    }
}

fun fibonaci():Iterable<Long>{
    var first = 0L
    var second = 1L
    return Iterable {
        object :LongIterator(){ //匿名函数
            override fun hasNext() = true

            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }

        }
    }
}

//方法add 返回一个方法，该方法将x 和传该方法参数相加
//fun add(x:Int) = fun(y: Int) = x + y

//和上面的一样
fun add(x:Int):(Int) -> Int{
//    data class Person(val name:String, val age:Int)//函数内部可以定义类，很少使用

    return fun(y:Int):Int{
        return x + y
    }
}

fun main(args: Array<String>) {
    val add5 = add(5)
    println(add5(2))


//    val x = makeFun()//函数中返回函数
//    x()
//    x()
//    x()
//    x()
//    x()


//    val x = fibonacci()
//    println(x())
//    println(x())
//    println(x())
//    println(x())
//    println(x())
//    println(x())

//    //每次for循环都执行fibonacci 方法， 相当于i++, fibonacci 方法返回的是数列，该数列每次增加一位
//    for (i in fibonaci()){
//        if(i> 100)break
//        println(i)
//    }
}