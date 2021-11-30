package ru.arvalon.hellokotlin.book.ch7

class PersonCh7 (val firstName: String, val lastName: String): Comparable<PersonCh7> {

    override fun compareTo(other: PersonCh7): Int {
        return compareValuesBy(this, other, PersonCh7::lastName, PersonCh7::firstName)
    }

    private var _emails: List<Email>? = null

    val emails: List<Email>

    get() {
        if (_emails == null){
            _emails = loadEmails(this)
        }
        return _emails!!
    }

    val emails2 by lazy { loadEmails(this) }
}