package ru.arvalon.hellokotlin.book.ch8

data class SiteVisit (val path: String, val duration: Double, val os: OS)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }.map(SiteVisit::duration).average()