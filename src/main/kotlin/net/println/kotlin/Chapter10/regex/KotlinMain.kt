package net.println.kotlin.Chapter10.regex

import java.util.regex.Pattern

fun main(args: Array<String>) {
    val source = "Hello,This my phone number:010-12345667"
    val pattern = ".*(\\d{3}-\\d{8}).*"
    val matcher = Pattern.compile(pattern).matcher(source)

    while (matcher.find()) {
        println(matcher.group())
        println(matcher.group(1))
    }
}