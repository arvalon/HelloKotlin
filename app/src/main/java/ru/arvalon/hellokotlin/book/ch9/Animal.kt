package ru.arvalon.hellokotlin.book.ch9

// Ковариативность
open class Animal {
    fun feed(){
        println("We feed!")
    }
}

// если тут не написать out
class Herd<out T: Animal>{
    val size: Int get() = 11
    operator fun get(i: Int): T? { return null}
}

fun feedAll (animals: Herd<Animal>){
    for (i in 0 until  animals.size) {
        animals[i]?.feed()
    }
}

class Cat: Animal(){
    fun cleanLitter(){
        println("Clean!")
    }
}

fun takeCareOfCats(cats: Herd<Cat>){
    for (i in 0 until cats.size){
        cats[i]?.cleanLitter()
    }
    feedAll(cats) // тут будет ошибка Type mismatch. Required: Herd<Animal> Found: Herd<Cat>
}