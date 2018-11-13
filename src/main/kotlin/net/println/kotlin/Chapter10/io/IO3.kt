package net.println.kotlin.Chapter10.io

import java.io.File

fun main(args: Array<String>) {
    File("build.gradle").readLines().forEach(::println)

}