package ru.arvalon.hellokotlin.book.ch6

class Person6(val name: String, val company: Company?)

class Person6_1(val firstName: String, val lastName: String){

    override fun equals(o: Any?): Boolean {

        val otherPerson = o as? Person6_1 ?: return false

        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)
