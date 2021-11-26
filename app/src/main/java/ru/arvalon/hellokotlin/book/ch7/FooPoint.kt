package ru.arvalon.hellokotlin.book.ch7

class FooPoint(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}