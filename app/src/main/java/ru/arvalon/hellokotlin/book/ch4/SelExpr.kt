package ru.arvalon.hellokotlin.book.ch4

/**
 * sealed позволяет убрать ветку по умолчанию из оператора when
 */
sealed class SelExpr {
    class Num (val value: Int) : SelExpr()
    class Sum (val left: SelExpr, val right: SelExpr) : SelExpr()
    class Multiple (val left: SelExpr, val right: SelExpr): SelExpr()
}

fun eval (e: SelExpr): Int = when (e) {
    is SelExpr.Num -> e.value
    is SelExpr.Sum -> eval(e.left) + eval(e.right)
    is SelExpr.Multiple -> eval(e.left) * eval(e.right)
}