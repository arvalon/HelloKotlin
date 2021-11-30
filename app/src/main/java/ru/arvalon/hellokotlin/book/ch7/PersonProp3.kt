package ru.arvalon.hellokotlin.book.ch7

class PersonProp3(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    var age: Int by ObservableProperty2(age, changeSupport)
    var salary: Int by ObservableProperty2(salary, changeSupport)
}