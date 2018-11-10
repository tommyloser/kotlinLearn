package net.println.kotlin.Chapter9.generics

fun main(args: Array<String>) {
    //out
    val numberList:List<Number> = listOf(1,2,3)

    val intComparable:Comparable<Int> = object:Comparable<Any>{
        override fun compareTo(other: Any): Int {
            return 0
        }
    }
}











//class MyList<in E>{
//    fun contains(element: E): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    fun containsAll(elements: Collection<E>): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//     fun indexOf(element: E): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//     fun lastIndexOf(element: E): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//     val size: Int
//        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
//
//     fun get(index: Int): @UnsafeVariance E {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//     fun isEmpty(): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//     fun iterator(): Iterator<E> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//     fun listIterator(): ListIterator<E> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//     fun listIterator(index: Int): ListIterator<E> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//     fun subList(fromIndex: Int, toIndex: Int): List<E> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//}