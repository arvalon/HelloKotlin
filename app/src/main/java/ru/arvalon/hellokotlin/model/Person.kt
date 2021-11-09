package ru.arvalon.hellokotlin.model

data class Person(val name : String, val age : Int? = null) {

    object NameComparator: Comparator<Person>{
        override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
    }
}