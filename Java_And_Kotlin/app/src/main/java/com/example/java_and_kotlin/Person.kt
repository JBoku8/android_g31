package com.example.java_and_kotlin

import java.util.*

class Person {
    private var name: String
    private var age: Int

    constructor(userName: String, userAge: Int){
        name = userName
        age = userAge
    }

    fun getInfo(): String {
        return "${name}, Age:${randomAge()}"
    }

    fun getName(): String {
        return name
    }

    fun randomAge(): Int {
        val rand = Random()
        return rand.nextInt(50) + 1
    }
}