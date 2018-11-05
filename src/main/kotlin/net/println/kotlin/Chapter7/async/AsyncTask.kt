package net.println.kotlin.Chapter7.async

import java.util.concurrent.Executors

private val pool by lazy {
    Executors.newCachedThreadPool()
}

class AsyncTask(val block: () -> Unit){
    /**
     * run （） 方法 的函数类型是 () -> Unit
     * Runnable 需要一个run() 方法 ， 也就是需要一个 （） -> Unit 的函数
     *
     */
//    fun execute() = pool.execute(Runnable(block))//Runnable, block 的类型很run()方法一致
    fun execute() = pool.execute(block)//Runnable, block 的类型很run()方法一致
//    fun execute() = pool.execute( object :Runnable{
//        override fun run() {
//            block
//        }
//    })//Runnable, block 的类型很run()方法一致
}