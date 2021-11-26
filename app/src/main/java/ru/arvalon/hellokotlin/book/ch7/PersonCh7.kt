package ru.arvalon.hellokotlin.book.ch7

class PersonCh7 (val firstName: String, val lastName: String): Comparable<PersonCh7> {

    override fun compareTo(other: PersonCh7): Int {
        return compareValuesBy(this, other, PersonCh7::lastName, PersonCh7::firstName)
    }
}