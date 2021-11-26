package ru.arvalon.hellokotlin.book.ch7

import java.lang.IndexOutOfBoundsException
import java.math.BigDecimal

data class Point(val x: Int, val y: Int){

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    override fun equals(obj: Any?): Boolean {
        if (obj === this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}

operator fun Point.times(scale: Double): Point{
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

operator fun Point.get(index: Int): Int{

    return when(index){
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}