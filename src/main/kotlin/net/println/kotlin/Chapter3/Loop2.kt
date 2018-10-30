package net.println.kotlin.Chapter3

class Student{
    fun isNotClothedProperty(): Boolean {
        return false
    }
}

fun main(args: Array<String>) {
    val students = ArrayList<Student>()
    val you = Student()
    for (student in students) {
        if (student == you) {
            continue
        }
        if (student.isNotClothedProperty()) {
            break
        }
    }
}