package strings

val String.lastChar2: Char get() = get(length - 1)

var StringBuilder.lastChar: Char get() = get(length-1)
set(value) {this.setCharAt(length-1, value)}

fun <T> Collection<T>.joinToString2(separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun <T> joinToStringStart2(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToString3(separator: String = ", ", prefix: String = "", postfix: String = ""): String {

    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "THE END"
) = joinToString3(separator, prefix, postfix)

fun String.lastChar(): Char = get(this.length-1)