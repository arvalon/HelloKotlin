package ru.arvalon.hellokotlin.book.ch4

class PrivateUser(override val nickname: String) : User {
    override val email: String
        get() = TODO("Not yet implemented")
}