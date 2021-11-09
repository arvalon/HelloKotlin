package ru.arvalon.hellokotlin.book.ch4

class LenghtCounter {

    var counter = 0
    private set

    fun addWord(word: String){
        counter += word.length
    }
}