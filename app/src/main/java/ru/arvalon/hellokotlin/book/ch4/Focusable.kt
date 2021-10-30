package ru.arvalon.hellokotlin.book.ch4

import android.util.Log
import ru.arvalon.hellokotlin.TAG2

interface Focusable {
    fun setFocus(b: Boolean) = Log.d(TAG2,"I ${if (b) "got" else "lost"} focus")
    fun showOff() = Log.d(TAG2, "I'm focusable!")
}