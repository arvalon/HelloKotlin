package ru.arvalon.hellokotlin.book.ch4

interface JSONFactory<T>{
    fun fromJSON(jsonText: String): T
}

class NetPerson(val name: String) {
    companion object: JSONFactory<NetPerson>{
        override fun fromJSON(jsonText: String): NetPerson = NetPerson("hello!")
    }
}