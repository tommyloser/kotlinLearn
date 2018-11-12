package net.println.kotlin.Chapter10

fun main(args: Array<String>) {
    val samIntJava = SAMInJava()
    val lambda = {
        println("Hello")
    }
    //这里传了一个lampda 表达式的实例
    /**
     * 对于只有一个方法的接口， 可以用lambda 表达式替代他
     */
    samIntJava.addTask {
        println("Hello")
    }

    //这里不能remove, 因为每次用lambda 编译成的runnable 对象都不一样
    samIntJava.addTask(lambda)
    samIntJava.addTask(lambda)
    samIntJava.addTask(lambda)
    samIntJava.addTask(lambda)

    samIntJava.removeTask(lambda)
    samIntJava.removeTask(lambda)
    samIntJava.removeTask(lambda)
    samIntJava.removeTask(lambda)

    //不支持kotlin 接口， 这里不能使用lambda 表达式
    val samIntKotlin = SAMInKotlin()
//    samIntKotlin.addTask(object :Runnable{
//        override fun run() {
//        }
//
//    })

    //kotlin 添加类型别名typealias，就可以是用lambda 表达式
    samIntKotlin.addTask {

    }
}