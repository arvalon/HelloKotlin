package ru.arvalon.hellokotlin.book.ch4

import android.util.Log
import ru.arvalon.hellokotlin.TAG2

interface Clicable {
    fun click()
    fun showOff() = Log.d(TAG2, "I'm clicable!")
}