package net.println.kotlin.Chapter4


abstract class A{
    var i = 0

    open fun hello() {
        println(i)
    }

    abstract fun world()
}

interface B{
    //继承接口需要实现该变量
    var j:Int//不可以初始化，get方法等

    fun hello() {
        println(j) //默认实现， 继承者可以不复写
    }

}

class D(override var j: Int) : B {
    override fun hello() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class E: A() {
    override fun world() {//抽象方法必须实现
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hello() {//open 的方法可以复写
        super.hello()
    }
}

interface F

class J(override var j: Int) : A(), B, F{

    override fun world() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hello() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

abstract class Mouse //本质

interface Optical //能力

//联想笔记本（电脑）

fun main(args: Array<String>) {
    val d = J(0)
    if (d is A) {

    }
    if (d is B){

    }
}