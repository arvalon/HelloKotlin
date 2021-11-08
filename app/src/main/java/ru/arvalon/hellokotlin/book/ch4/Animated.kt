package ru.arvalon.hellokotlin.book.ch4

abstract class Animated {

    abstract fun animate()
    open fun stopAnimating(){}
    fun animateTwice(){}
}