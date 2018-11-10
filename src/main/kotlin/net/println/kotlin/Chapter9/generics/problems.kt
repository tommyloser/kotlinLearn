package net.println.kotlin.Chapter9.generics

import com.google.gson.Gson
import java.io.File

fun main(args: Array<String>) {
//    testGenerics<String>()
    val person = Person("tommy", 18)
    Gson().toJson(person).let {
        File("person.json").writeText(it)
    }

    needAPerson(Gson().fromJson(File("person.json").readText()))
//    val person1:Person = Gson().fromJson<Person>(File("person.json").readText())
}

fun needAPerson(person: Person) {

}

//这里不能重载的原因是， List编译完成 ，就没有泛型了， 所有叫伪泛型, 所以算同一个类
fun needAList(list : List<Double>){

}

//fun needAList(list: List<Int>){
//
//}
/**
 * inline 把代码植入到调用处， 所有这里打印泛型的类型了
 */
inline fun <reified T> testGenerics() {
    println(T::class.java)
//    val a:T? = null
}

data class Person(val name:String, val age:Int)

//kotlin 虽然是伪泛型，但是能部分实行真泛型的功能
inline fun <reified T> Gson.fromJson(json:String):T = fromJson(json, T::class.java)