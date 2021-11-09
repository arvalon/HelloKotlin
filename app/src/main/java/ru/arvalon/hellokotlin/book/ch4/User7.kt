package ru.arvalon.hellokotlin.book.ch4

import android.util.Log
import ru.arvalon.hellokotlin.TAG2

class User7(val name: String) {

    var address = "unspecified"

    set(value) {
        Log.d(TAG2,"""Address was changed for $name:"$field" -> "$value".""".trimIndent())
        field = value
    }
}