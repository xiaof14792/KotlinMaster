package com.example.officialpractice.coroutines.coroutine_context_dispatchers

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.math.log

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

/**
 * 调试协程与线程
 *
 * 当 JVM 以 -ea 参数配置运行时，调试模式也会开启
 */
fun main() = runBlocking<Unit> {
    val a = async {
        log("I am computing a piece of answer")
        7
    }

    val b = async {
        log("I am computing another piece of answer")
        41
    }

    log("The answer is ${a.await() + b.await()}")
}