package net.println.kotlin.Chapter10.io

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main(args: Array<String>) {
    val file = File("build.gradle")
    BufferedReader(FileReader(file)).use {
        var line:String
        while (true) {
            line = it.readLine()?:break
            println(line)
        }
    }
}