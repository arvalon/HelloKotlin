package ru.arvalon.hellokotlin.book.ch7

data class Email (var email: String)

fun loadEmails(person: PersonCh7): List<Email>{
    println("Load emails for ${person.firstName}")
    return listOf(Email("me@qwerty.ru"), Email("she@qwerty.ru"))
    //return listOf(/*...8/)
}