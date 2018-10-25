package net.println.kotlin

fun getName2(): String {
    return "xianming"
}

fun getName(): String? {
    return null
}

fun main(args: Array<String>) {
    val name = getName()
//    if (name == null) {
//        println("name is invalid")
//    } else {
//        println(name.length)
//    }
    //简化代码
    println(name?.length)

//    if(name == null) return
    //简化,如果为空返回， 否则赋值，所有name2 不为空
    val name2:String = getName()?:return//?:判断签名表达式为空，则只需后面的return
    println(name2.length)

    val value:String? = "HelloWorld"
    println(value!!.length)//我知道不为空，强制执行
}