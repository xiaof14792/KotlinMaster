package com.example.officialpractice.coroutines.composing_suspending_functinos

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 使用 async 的结构化并发
 * 提取出一个函数并发的调用 doSomethingUsefulOne 与 doSomethingUsefulTwo 并且返回它们两个的结果之和。
 * 由于 async 被定义为了 CoroutineScope 上的扩展，我们需要将它写在作用域内，并且这是 coroutineScope 函数所提供的：
 *
 * 这种情况下，如果在 concurrentSum 函数内部发生了错误，并且它抛出了一个异常， 所有在作用域中启动的协程都会被取消。
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        println("the answer is ${concurrentSum()}")
    }

    println("completed in $time ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }

    one.await() + two.await()
}