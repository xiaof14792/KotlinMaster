package com.example.officialpractice.coroutines.coroutine_context_dispatchers


import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 父协程的职责
 *
 * 一个父协程总是等待所有的子协程执行结束。父协程并不显式的跟踪所有子协程的启动，并且不必使用 Job.join 在最后的时候等待它们：
 */
fun main() = runBlocking<Unit> {
    val request = launch {
        repeat(3){i ->
            launch {
                delay((i + 1) * 200L)
                println("coroutine $i is done")
            }
        }

        println("request: I'm done and I don't explicitly join my children that are still active")
    }

    request.join() // 等待请求的完成，包括其所有子协程
    println("Now processing of the request is complete")
}