package net.println.kotlin.Chapter4

class Manager : Driver,Writer {
    override fun drive() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun write() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
//

}

//接口代理by
class SeniorManager(val driver: Driver,val writer: Writer):Driver by driver, Writer{
//    override fun drive() {
//        driver.drive()
//    }

    override fun write() {
        writer.write()
    }

}

class CarDriver:Driver{
    override fun drive() {
        println("开车呢")
    }
}

class PPTWriter:Writer{
    override fun write() {
        println("做PPT呢")
    }
}

interface Driver{
    fun drive()
}

interface Writer{
    fun write()
}

fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()
    val seniorManager = SeniorManager(driver, writer)
    seniorManager.drive()
    seniorManager.write()
}