package net.println.kotlin.Chapter5.compose

//f(g(x))  m(x) = f(g(x))

val add5 = {i:Int -> i + 5}
val multiplyBy2 = {i:Int -> i * 2}

fun main(args: Array<String>) {
    println(multiplyBy2(add5(8)))// (5+8）*2

    val add5AndMultiplyBy2 = add5 andThen multiplyBy2 //先算前面
    val add5ComposeMultiplyBy2 = add5 compose  multiplyBy2 //先算后面
    println(add5ComposeMultiplyBy2(8))//m(x) = f(g(x)) //8*2 +5 加5 之前* 2
    println(add5AndMultiplyBy2(8))//m(x) = g(f(x)) //8+5 * 2
}

//复合函数 add5 = function1, multiplyby2 = function
infix fun <P1, P2,R> Function1<P1, P2>.andThen(function:Function1<P2, R>):Function1<P1,R>{//中缀表达式，扩展方法，23个function
    return fun(p1:P1):R {
        return function.invoke(this.invoke(p1))//multiplyBye(add5(8), function= multiplyby this = add5, p1 = 8
    }
}

//Function1 的扩展方法， 接受一个Function1, 返回一个function1
infix fun <P1,P2,R> Function1<P2,R>.compose(function:Function1<P1,P2>):Function1<P1,R>{
    return fun(p1:P1):R {
        return this.invoke(function.invoke(p1))
    }
}