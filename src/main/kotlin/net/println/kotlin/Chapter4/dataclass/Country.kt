package net.println.kotlin.Chapter4.dataclass

import net.println.kotlin.Chapter4.annotations.PoKo

@PoKo
data class Country(val id: Int, val name: String)

class ComponentX{
    operator fun component1():String{
        return "您好，我是"
    }
    operator fun component2(): Int{
        return 1
    }
    operator fun component3():Int{
        return 0
    }
}
fun main(args: Array<String>) {
    val china = Country(0, "中国")
    println(china)
    println(china.component1())//第一个参数
    println(china.component2())

    val(id, name) = china
    println(id)
    println(name)

//    for ((index, value) in args.withIndex()) {
//        println(index)
//        println(value)
//    }

    val componentX = ComponentX()
    val (a,b,c) = componentX
    println("$a$b$c")
}