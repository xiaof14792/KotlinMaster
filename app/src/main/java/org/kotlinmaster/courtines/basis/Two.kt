package org.kotlinmaster.courtines.basis

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = GlobalScope.launch { //launch a coroutine and keep a reference to its Job
        delay(1000L)
        println("World.")
    }

    println("Hello,")
//    delay(2000L)
    job.join() //wait until child coroutine completes
}