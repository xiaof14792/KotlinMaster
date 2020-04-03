package com.example.officialpractice.coroutines.basis

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { //this: CoroutineScope
    launch { //launch a new coroutine in the scope of runBlocking
        delay(1000L)
        println("World!")
    }

    println("Hello,")
}