package net.println.kotlin.Chapter4.Confilct

class House

class Flower

class Countyard{
    private val house: House = House()
    private val flower:Flower = Flower()

}

class ForbiddenCity{
    //private protected internal//模块内可见 public
     val houses = arrayOf(House(), House())
     val flowers = arrayOf(Flower(), Flower())
}

fun main(args: Array<String>) {
    val countyard = Countyard()
    val fc = ForbiddenCity()
    println()
    println(fc.flowers)
}