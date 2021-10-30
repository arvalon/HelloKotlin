package ru.arvalon.hellokotlin.book.ch4

import android.util.Log
import ru.arvalon.hellokotlin.TAG2

class MyButton: Clicable, Focusable {

    override fun click() {
        Log.d(TAG2,"click")
    }

    override fun showOff(): Int {
        super<Clicable>.showOff()
        super<Focusable>.showOff()
        return 0
    }
}