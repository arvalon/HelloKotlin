package ru.arvalon.hellokotlin.book.ch8

class ContactListFilters {

    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (ContactPerson) -> Boolean {

        val startsWithPrefix = { p: ContactPerson ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }

        if (!onlyWithPhoneNumber) { return startsWithPrefix }

        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}