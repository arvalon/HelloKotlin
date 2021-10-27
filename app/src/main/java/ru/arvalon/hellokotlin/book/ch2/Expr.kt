package ru.arvalon.hellokotlin.book.ch2

interface Expr {
    class Num(val value : Int) : Expr
    class Sum(val left : Expr, val right : Expr) : Expr
    class Multipl (val left: Expr, val right: Expr) : Expr
}