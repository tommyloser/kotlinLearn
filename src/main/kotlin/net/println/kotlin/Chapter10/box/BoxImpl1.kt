package net.println.kotlin.Chapter10.box

//用kotlin 实现 java 的接口, 因为kotlin 不区分装箱， 所以两个接口视为同一个
class BoxImpl1:BoxIf1{
    override fun get(key: Int): String {
        return "Hello"
    }

//    override fun get(key: Int?): String {z
//        return "Hello"
//    }

}