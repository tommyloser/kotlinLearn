package net.println.kotlin.Chapter8

import net.println.kotlin.Chapter4.annotations.AnotherAnno
import net.println.kotlin.Chapter4.annotations.PoKo
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberExtensionFunctions
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

@PoKo
data class Person(@AnotherAnno val name: String, var age: Int){
    fun hello() {
        println("Hello")
    }

    fun hello2() {
        println("Hello2")
    }

    fun String.times(other: Int) {

    }
}

class NoPrimaryContructor{
    constructor(){
        println("no primary, no arg")
    }

    constructor(int: Int){
        println("not primary, arg: $int")
    }
}

class DefaultConstructor()

//定义扩展方法
fun Person.sayHello() {
    println("Hello")
}

//包级方法
fun sayHello() {
    println("Hello")
}

fun main(args: Array<String>) {
    val clazz = Person::class.java
    val kclazz = Person::class

    val person = Person("benny", 18)
    val clazz2 = person.javaClass
    //这里返回切边的KClass<out Person> 因为 person 实例可能是person的子类
    val kClass2 = person::class


    val clazz3 = person.javaClass
    val kClazz3  = person.javaClass.kotlin
//--------构造方法
    val defaultConstructor = DefaultConstructor::class.java.newInstance()

    //主构造器
    val primaryConstructor = kClass2.primaryConstructor!!
    val kPerson = primaryConstructor.call("tommy", 18)
    println("kperson: $kPerson")
//    NoPrimaryContructor::class.constructors.forEach(::println)
    NoPrimaryContructor::class.constructors.first().call()
    NoPrimaryContructor::class.constructors.last().call(1)


    val person2 = clazz2.getConstructor(String::class.java, Int::class.java).newInstance("tommy", 18)
    //使用反射实例化对象会属性为空， Person(name=null, age=0
//    val person2 = clazz2.newInstance()//调用 默认的无参构造方法
    println(person2)


    // ---------访问成员
    //读取
//    val name = clazz2.getDeclaredField("name").apply {isAccessible = true }.get(person2)
    //赋值
    clazz2.getDeclaredField("name").apply {isAccessible = true }.set(person2, "Andy")
    //放射掉用方法
//    val name2 = clazz2.getDeclaredMethod("getName").invoke(person2)
    //反射调用有参数的方法
    val person3 = clazz2.getDeclaredMethod("copy", String::class.java, Int::class.java).invoke(person2, person2.name,person2.age)

    //kotlin没有获取单个属性的方法
//    kClass2.memberProperties.forEach(::println)
    kclazz.memberProperties.first{it.name == "age"}.get(kPerson).let { println(it) }

    //要设置属性必须强制成KmutablePropertiy1 <> 加泛型参数， 才能用set 方法
    (kclazz.memberProperties.first { it.name == "age" } as? KMutableProperty1<Person, Int>)?.set(kPerson, 16)
    println(kPerson)
//    println(name)
//    println(name2)
//    println(person3)

    //-------------使用反射访问扩展方法
//    person2.sayHello()
//    JavaReflectionsKt//kotlin 这个类不可见
    //所有使用下面这种方式
//    Class.forName("net.println.kotlin.Chapter8.JavaReflectionsKt")
//            .getDeclaredMethod("sayHello",Person::class.java )
//            .invoke(null, person2)

    //包级方法
    Class.forName("net.println.kotlin.Chapter8.JavaReflectionsKt")
            .getDeclaredMethod("sayHello" )
            .invoke( person2)

    // --------- 注解
    clazz.getAnnotation(PoKo::class.java).let(::println)
    //多个注解
//    clazz.getAnnotationsByType(PoKo::class.java).let(::println)

    clazz.getDeclaredField("name").annotations.forEach {
        println(it)
    }

    kclazz.memberFunctions.forEach{
        println(it)
    }
    println("扩展方法")
    //调用扩展方法
    kclazz.memberExtensionFunctions.forEach(::println)

    println("注解")
    kclazz.annotations.forEach(::println)
    kclazz.memberProperties.first{it.name == "name"}.annotations.forEach(::println)
}