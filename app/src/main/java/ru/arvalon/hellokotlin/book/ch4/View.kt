package ru.arvalon.hellokotlin.book.ch4

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State){}
}