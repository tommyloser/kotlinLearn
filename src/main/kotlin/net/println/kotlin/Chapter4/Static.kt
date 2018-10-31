package net.println.kotlin.Chapter4

fun main(args: Array<String>) {
//    val a = minOf(args[0].toInt(), args[1].toInt())

    val latitude = Latitude.ofDouble(3.0)
    val latitude2 = Latitude.ofLatitude(latitude)

    println(Latitude.TAG)
}

class Latitude private constructor(val value: Double){
    companion object {//半身对象
        @JvmStatic
        fun ofDouble(double:Double):Latitude{//相对于java的静态方法
            return Latitude(double)
        }

        fun ofLatitude(latitude: Latitude): Latitude{
            return Latitude(latitude.value)
        }
        @JvmField
        val TAG:String = "Latitude"
    }
}