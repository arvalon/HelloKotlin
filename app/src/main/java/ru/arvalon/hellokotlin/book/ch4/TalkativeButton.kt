package ru.arvalon.hellokotlin.book.ch4

import android.util.Log
import ru.arvalon.hellokotlin.TAG2

internal open class TalkativeButton: Focusable {
    private fun yell() = Log.d(TAG2,"Hey!")
    protected fun whisper() = Log.d(TAG2, "Let's talk!")
}

// всё с ошибками
/*
fun TalkativeButton.giveSpeech(){
    yell()
    whisper()
}*/