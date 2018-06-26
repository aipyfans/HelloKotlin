package com.william.dream.kotlin01

data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", 25))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("the oldest is : $oldest")
}