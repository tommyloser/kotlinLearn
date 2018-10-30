package net.println.kotlin.Chapter3

private const val USERNAME = "kotlin"
private const val PASSWORD = "jetbrains"

private const val ADMIN_USER = "admin"
private const val ADMIN_PASSWD = "admin"

private const val DEBUG = 1
private const val USER = 0

fun main(args: Array<String>) {
    val mode = //条件表达式
    if (args.isNotEmpty() && args[0] == "1") {
        DEBUG
    } else {
        USER
    }


    println("请输入用户名：")
    val username = readLine()
    println("请输入密码：")
    val passwd = readLine()

    if (mode == DEBUG && username == ADMIN_USER && passwd == ADMIN_PASSWD) {
        println("管理员登录成功")
    }else

    if (username == USERNAME && passwd == PASSWORD) {
        println("登录成功")
    } else {
        println("登录失败")
    }
}