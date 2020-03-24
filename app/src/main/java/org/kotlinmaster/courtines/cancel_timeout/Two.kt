package org.kotlinmaster.courtines.cancel_timeout

import kotlinx.coroutines.*

/*
 * 所有 kotlinx.coroutines 中的挂起函数都是 可被取消的 。它们检查协程的取消， 并在取消时抛出 CancellationException。
 * 然而，如果协程正在执行计算任务，并且没有检查取消的话，那么它是不能被取消的
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        val i = 0
        while (i < 5) { //computation loop, just waste CPU
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: i am sleeping $i++")
                nextPrintTime += 500
            }
        }
    }

    delay(1300) //delay a bit
    println("main: i am tired of waiting")
    job.cancelAndJoin() //cancel the job and waits for its completion
    println("main: now, i can quit")
}