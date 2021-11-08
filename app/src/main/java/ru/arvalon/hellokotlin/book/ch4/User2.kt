package ru.arvalon.hellokotlin.book.ch4

class User2 constructor(_nickname: String, name: String) {
    val nickname: String
    val name:String

    init {
        nickname = _nickname
        this.name = name
    }
}