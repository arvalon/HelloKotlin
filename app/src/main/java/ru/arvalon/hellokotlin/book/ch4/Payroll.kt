package ru.arvalon.hellokotlin.book.ch4

import ru.arvalon.hellokotlin.model.Person

/** Синглтон из коробки */
object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary(){
        for (allEmployee in allEmployees) {
            // calc salary
        }
    }
}