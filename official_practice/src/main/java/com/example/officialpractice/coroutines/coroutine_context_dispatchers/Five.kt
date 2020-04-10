package com.example.officialpractice.coroutines.coroutine_context_dispatchers

import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

/**
 * 上下文中的作业
 * 协程的Job是上下文的一部分，并且可以使用coroutineContext[Job]在上下文中检索它
 */
fun main() = runBlocking<Unit> {
    println("My job is ${coroutineContext[Job]}")
}