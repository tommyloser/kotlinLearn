package net.println.kotlin.Chapter3

class 妹子(var 性格:String, var 长相:String, var 声音:String){
    fun 唱歌(歌名: String) {
        //
        println("妹纸正在唱$歌名")
    }

    fun 跳舞(舞蹈名: String) {
        //
        println("妹子正在跳$舞蹈名")
    }
}

fun main(args: Array<String>) {
    val 某个妹子 = 妹子("彪悍", "未知", "没听过")
    某个妹子.唱歌("歌唱祖国")
    某个妹子.跳舞("机械舞")
}