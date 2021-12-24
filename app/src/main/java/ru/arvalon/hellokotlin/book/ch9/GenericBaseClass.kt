package ru.arvalon.hellokotlin.book.ch9

val <T> List<T>.penultimate: T
get() = this[size - 2]

fun <T: Number> oneHalf(value: T): Double {
    return value.toDouble() / 2
}

fun <T: Comparable<T>> genericMax (first: T, second: T): T{
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T) where T: CharSequence, T: Appendable{
    if (!seq.endsWith('.')){
        seq.append('.')
    }
}

fun printCollectionSum(c: Collection<*>){
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun printCollectionSum2(c: Collection<Int>) {
    if (c is List<Int>) {
        println(c.sum())
    }
}

inline fun <reified T> isA(value: Any) = value is T

class GenericBaseClass {
}