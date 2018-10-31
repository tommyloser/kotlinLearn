package net.println.kotlin.Chapter4.SealedClasses

/*
sealed class 的子类只能定义在同一个文件当中
子类可数
 */
sealed class PlayerCmd {
    class Play(val url:String, val position: Long = 0):PlayerCmd()

    class Seek(val position:Long):PlayerCmd()

    object Pause:PlayerCmd()

    object Resume:PlayerCmd()

    object Stop:PlayerCmd()
}

//实例可数
enum class PlayerState{
    IDLE, PAUSE, PLAYING
}
