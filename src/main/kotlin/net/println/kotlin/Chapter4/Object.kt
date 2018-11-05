package net.println.kotlin.Chapter4

class Driverr
interface OnExternalDriverMountListerer{
    fun onMount(driverr:Driverr)

    fun onUnmount(driver:Driverr)
}

//fun setListener(onExternalDriverMountListerer: OnExternalDriverMountListerer){
//    val a = onExternalDriverMountListerer
//}
//
//fun main(args: Array<String>) {
//    val block = { println("aaa")}
//    setListener(block)
//
//}
abstract class Player

object MusicPlayer: Player(),OnExternalDriverMountListerer{
    override fun onMount(driverr: Driverr) {

    }

    override fun onUnmount(driver: Driverr) {
    }

    //单例
    val state:Int = 0

    fun play(url: String) {

    }

    fun stop() {

    }
}