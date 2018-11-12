package net.println.kotlin.Chapter10.regex

fun main(args: Array<String>) {
    val source = "Hello,This my phone number:010-12345667"
//    val pattern = ".*(\\d{3}-\\d{8}).*"
    val pattern = """.*(\d{3}-\d{8}).*"""

    Regex(pattern).findAll(source).toList().flatMap (MatchResult::groupValues).forEach(::println)
}