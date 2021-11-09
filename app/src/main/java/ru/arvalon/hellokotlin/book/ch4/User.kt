package ru.arvalon.hellokotlin.book.ch4

interface User {
    val nickname: String

    val email:String

    val nickname2: String
        get() = email.substringBefore('@')
}