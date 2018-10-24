package net.println.kotlin

val aChar:Char = '0'
val bChar:Char = '中'
val cChar:Char = '\u000f'//\u 是uni code编码
/*
转义字符
\t 制表符
\b 光标后退一个字符
\n 回车
\r 光标回到首行
\'
\"
\\
\$
 */
fun main(args: Array<String>) {
    println(aChar)
    println(bChar)
    println(cChar)
}
