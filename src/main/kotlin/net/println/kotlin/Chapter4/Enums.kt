package net.println.kotlin.Chapter4

enum class LogLevel(val id:Int){
    VERBOSE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), ASSERT(5);

    fun getTag():String{
        return "$id, $name"
    }

    override fun toString(): String {
        return "$name, $ordinal"
    }
}

fun main(args: Array<String>) {
    println(LogLevel.DEBUG.getTag())
    println(LogLevel.DEBUG.ordinal) // 顺序
    LogLevel.values().map(::println)//获取所有实例

    println(LogLevel.valueOf("error".toUpperCase()))//获取单个实例
}

class LogLevel2 protected constructor(){ //模仿枚举
    companion object {
        val VERBOSE = LogLevel2()
        val DEBUG = LogLevel2()
        val INFO = LogLevel2()
        val WARN = LogLevel2()
        val ASSERT = LogLevel2()
    }
}