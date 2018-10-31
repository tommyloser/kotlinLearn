package net.println.kotlin.Chapter4.innerClass

open class Outter{

    val a:Int = 0
    class Inner{ //默认public, 静态内部类
//        fun hello() {
//            println(a)
//        }
    }

    inner class Inner2{//非静态内部类
        val a:Int = 5
        //非静态内部类
        fun hello() {
            this.a
            println(a)
            println(this@Outter.a)//全称
        }
    }


}

interface OnClickListener{
    fun onClick()
}

class View{
     var onClickListener:OnClickListener? = null

}

fun main(args: Array<String>) {
//    val inner = Outter.Inner()
//    val out = Outter()
//    val inner2 = out.Inner2()
//    val inner3 = Outter.Inner2()
    val view = View()
    //匿名内部类, 可以继承一个类， 实现接口
    view.onClickListener = object : Outter(),OnClickListener{
        override fun onClick() {

        }

    }
}