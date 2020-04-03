package com.example.officialpractice.coroutines.cancel_timeout

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000){ i ->
            println("job: i am sleeping $i ...")
            delay(500)
        }
    }

    delay(1300) //delay a bit
    println("main: i am tired of waiting")
    job.cancel() //cancels the job
    job.join() //waits for the job's completion
    println("main: now, i can quit")
}