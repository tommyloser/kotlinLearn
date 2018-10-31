package net.println.kotlin.Chapter4

class Driverr
interface OnExternalDriverMountListerer{
    fun onMount(driverr:Driverr)

    fun onUnmount(driver:Driverr)
}

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