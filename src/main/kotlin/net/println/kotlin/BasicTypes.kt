package net.println.kotlin

val aBoolean:Boolean = true
val anotherBoolean: Boolean = false

val anInt:Int = 8
val anotherInt: Int = 0xff
val moreInt: Int = 0b00000011
val maxInt: Int = Int.MAX_VALUE
val minInt : Int = Int.MIN_VALUE

val aLong:Long = 1324565457987
val another:Long = 123
val maxLong:Long = Long.MAX_VALUE
val minLong:Long = Long.MIN_VALUE

val aFloat:Float = 2.0f
val anotherFloat: Float = 1e3f //1000
val maxFloat:Float = Float.MAX_VALUE
val minFloat:Float = Float.MIN_VALUE //最小的正值
val minFloat_a:Float = -Float.MAX_VALUE //真正的最小值

val aDouble:Double = 3.0
val anotherDouble:Double = 3.1415926
val maxDouble:Double = Double.MAX_VALUE
val minDouble:Double = Double.MIN_VALUE//最小的整数

val aShort:Short = 127
val maxShort:Short = Short.MAX_VALUE
val minShort:Short = Short.MIN_VALUE

val byte:Byte = 127 //最大
val maxByte:Byte = Byte.MAX_VALUE
val minByte:Byte = Byte.MIN_VALUE
fun main(args: Array<String>) {
    println(anotherInt)
    println(moreInt)
//    println(13L)
    println(maxInt)
    println(Math.pow(2.0, 31.0)-1)
    println(minInt)
    println(-Math.pow(2.0, 31.0))

    println(maxLong)
    println(Math.pow(2.0, 63.0)-1)
    println(minLong)
    println(-Math.pow(2.0, 63.0))

    println(aFloat)
    println(anotherFloat)
    println(maxFloat)
    println(minFloat)

    println(.0f/.0f)//NaN 不是数的数
    println((.0f/.0f) == Float.NaN)//false 不相等， 没有意义

    println(maxDouble)
    println(minDouble)

    println(maxShort)
    println(minShort)

    println(maxByte)
    println(minByte)
}