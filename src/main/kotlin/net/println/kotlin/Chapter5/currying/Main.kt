package net.println.kotlin.Chapter5.currying

import net.println.kotlin.Chapter5.compose.add5
import net.println.kotlin.Chapter5.compose.andThen
import net.println.kotlin.Chapter5.compose.multiplyBy2
import java.io.OutputStream
import java.nio.charset.Charset

//fun hello(x:String, y:Int, z:Double):Boolean{
//    return true
//}
//
//fun curriedHello(x: String): (y: Int) -> (z: Double) -> Boolean {
//
//}
fun log(tag: String, target: OutputStream, message: Any?) {
    target.write("{$tag} $message\n".toByteArray())

}

//fun log(tag:String):(target:OutputStream) -> (message:Any?){
//    return fun()
//}

//fun log(tag:String)
//=fun(target:OutputStream)//返回一个函数，(target:OutputStream) -> 返回值是下一行
//=fun(message:Any?) //返回一个函数， （message:Any?) -> 返回值是原函数的表达式
//=target.write("{$tag} $message\n".toByteArray())

fun main(args: Array<String>) {
    log("benny", System.out, "HelloWorld")
//    log("benny")( System.out)( "HelloWorld Again")
    //::log.curried() 函数引用， 调用curried ()方法柯理化
//    ::log.curried()("benny")( System.out)( "HelloWorld Again")

    //偏函数， 有个默认值
    val consoleLogWithTag = (::log.curried())("benny")(System.out)
    consoleLogWithTag("HelloAgain Again")

    val bytes = "我是中国人".toByteArray(charset("GBK"))
    makeStringFromGbkBytes(bytes)

    //导入三个函数，add5 andThen multiplyBy2
    val add5AndMultiplyBy2 = add5 andThen multiplyBy2 //先算前面
    println(add5AndMultiplyBy2(4))

}

//定义了3个参数版本的柯理化， 定义了一个Function3的扩展方法， 所有function3的函数都可以调用， 他返回一个柯理化的函数
fun <P1,P2,P3,R> Function3<P1,P2,P3,R>.curried()//Funciton3是lambda 表达式的类型
        = fun(p1:P1) = fun(p2:P2) = fun(p3:P3) = this(p1, p2, p3)

val makeString = fun(byteArray: ByteArray, charset: Charset): String {
    return String(byteArray, charset)
}

val makeStringFromGbkBytes = makeString.partial2(charset("GBK"))

/*
定义扩展方法， partial2 , 出入第二个参数， 返回一个方法（该方法传入第一个参数， 返回原方法体 this(p1, p2)
 */
fun <P1, P2, R> Function2<P1,P2,R>.partial2(p2:P2) = fun(p1: P1) = this(p1, p2)
fun <P1, P2, R> Function2<P1,P2,R>.partial1(p1: P1) = fun(p2: P2) = this(p1, p2)

