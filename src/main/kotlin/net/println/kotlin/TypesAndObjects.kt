package net.println.kotlin

class 妹子2 constructor(var 性格:String, var 长相:String, var 声音:String){}
//只有一个构造方法可以省略constructor， 大括号没有内容也可以省略
class 妹子3(var 性格:String, var 长相:String, var 声音:String)

class 妹子(性格:String, 长相:String, 声音:String):人(性格, 长相, 声音){
//    init {//构造方法的方法体
//        println("new 了一个妹子，她性格$性格， 长相$长相， 声音$声音")
//    }
}

class 帅哥(性格:String, 长相:String, 声音:String):人(性格, 长相, 声音){
//    init {
//        println("new 了一个帅哥，他性格$性格， 长相$长相， 声音$声音")
//    }
}

open class 人(var 性格: String, var 长相: String, var 声音: String){
    init {
        println("new 了一个${this.javaClass.simpleName}，ta性格$性格， 长相$长相， 声音$声音")
    }
}
fun main(args: Array<String>) {
    val 我喜欢的妹子:妹子 = 妹子("温柔", "甜美", "动人 ")
    val 我膜拜的帅哥:帅哥 = 帅哥("彪悍", "帅哥", "浑厚 ")
    println(我喜欢的妹子 is 人)//是否子类

}