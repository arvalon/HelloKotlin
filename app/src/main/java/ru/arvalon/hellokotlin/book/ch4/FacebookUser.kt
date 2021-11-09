package ru.arvalon.hellokotlin.book.ch4

fun getFacebookName(accountId: Int) = "fb:$accountId"

class FacebookUser(val accountId: Int, override val email: String): User {
    override val nickname = getFacebookName(accountId)
}