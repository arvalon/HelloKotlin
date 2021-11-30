package ru.arvalon.hellokotlin.book.ch7

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class PersonProp4(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    private val observer = {
            prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}