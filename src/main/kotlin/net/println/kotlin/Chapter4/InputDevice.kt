package net.println.kotlin.Chapter4

import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException

interface InputDevice {
    fun input(event: Any)

}

interface USBInputDevice:InputDevice

interface BLEInputDevice:InputDevice

abstract class USBMouse(val name:String):USBInputDevice,OpticalMouse{
    override fun input(event: Any) {

    }

    override fun toString(): String {
        return name
    }
}

class LogittechMouse(var xinghao:String) : USBMouse("罗技鼠标 $xinghao") {

}

interface OpticalMouse{

}

class Computer{
    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        println("add usb input device:$inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        println("add bie input device:$inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is BLEInputDevice -> addBLEInputDevice(inputDevice)
            is USBInputDevice -> addUSBInputDevice(inputDevice)
            else -> throw IllegalArgumentException("输入设备类型不支持")
        }
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
    val mouse = LogittechMouse("a3b4")
    computer.addUSBInputDevice(mouse)
}