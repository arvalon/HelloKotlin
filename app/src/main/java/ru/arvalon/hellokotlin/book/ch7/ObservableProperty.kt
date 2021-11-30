package ru.arvalon.hellokotlin.book.ch7

import java.beans.PropertyChangeSupport

class ObservableProperty(val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport)
{
    fun getValue(): Int = propValue

    fun setValue(newValue: Int) {

        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}