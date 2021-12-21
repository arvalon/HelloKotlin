package ru.arvalon.hellokotlin.book.ch8

class BaseClass {
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {

    val sb = StringBuilder()

    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }

    return sb.toString()
}

fun <T> Collection<T>.joinToString4(

    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToString5(

    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null): String
{
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {

        if (index > 0) result.append(separator)

        val str = transform?.invoke(element) ?: element.toString()

        result.append(str)
    }

    result.append(postfix)
    return result.toString()
}

enum class Delivery {STANDARD, EXPEDITED}

class Order (val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {

    if (delivery == Delivery.EXPEDITED){
        return  {order ->6 + 1.2 * order.itemCount}
    }
    return  {order -> 1.2 * order.itemCount}
}