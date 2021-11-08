package ru.arvalon.hellokotlin.book.ch4

open class RichButton: Clicable {

    fun disable(){}
    open fun animated(){}
    open fun animated2(){}
    final override fun click() {}
}