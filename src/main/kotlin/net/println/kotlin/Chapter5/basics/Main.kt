package net.println.kotlin.Chapter5.basics

fun main(args: Array<String>) {
    args.forEach (::println)

    val helloWorld = Hello::world //方法应用

    args.filter (String::isNotEmpty) //扩展方法，没有参数，但 自身就是一个参数
    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)//使用这个实例调用， 只需要一个参数
}

class PdfPrinter{
    fun println(any: Any) {
        kotlin.io.println(any)
    }
}



class Hello{
    fun world() {
        println("Hello World")
    }
}