package com.example.officialpractice.coroutines.composing_suspending_functinos

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 默认顺序调用
 */
fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("the answer is ${one + two}")
    }
    println("completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int{
    delay(1000)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int{
    delay(1000)
    return 19
}