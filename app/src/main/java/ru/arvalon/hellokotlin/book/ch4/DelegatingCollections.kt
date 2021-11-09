package ru.arvalon.hellokotlin.book.ch4

class DelegatingCollections<T> (innerList: Collection<T> = ArrayList<T>()): Collection<T> by innerList {
}