package ru.arvalon.hellokotlin.book.ch4

class CompanionUser {

    val nickname: String

    constructor(email: String){
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int){
        nickname = getFacebookName(facebookAccountId)
    }

    companion object {
        fun newSubscribingUser(email: String) = CompanionUser(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) = CompanionUser(getFacebookName(accountId))
    }
}