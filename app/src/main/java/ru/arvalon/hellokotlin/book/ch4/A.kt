package ru.arvalon.hellokotlin.book.ch4

import android.util.Log
import ru.arvalon.hellokotlin.MainActivity.Companion.TAG

class A {
    companion object{
        fun bar(){
            Log.d(TAG,"Companion object called")
        }
    }
}