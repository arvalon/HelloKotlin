package ru.arvalon.hellokotlin.book.ch7

data class Point(val x: Int, val y: Int){

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

operator fun Point.times(scale: Double): Point{
    return Point((x * scale).toInt(), (y * scale).toInt())
}
