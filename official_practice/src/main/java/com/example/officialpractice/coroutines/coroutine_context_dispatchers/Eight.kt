package com.example.officialpractice.coroutines.coroutine_context_dispatchers


import kotlinx.coroutines.*

/**
 * 命名协程以用于调试
 *
 * 当协程经常打印日志并且你只需要关联来自同一个协程的日志记录时， 则自动分配的 id 是非常好的。
 * 然而，当一个协程与特定请求的处理相关联时或做一些特定的后台任务，最好将其明确命名以用于调试目的。
 * CoroutineName 上下文元素与线程名具有相同的目的。当调试模式开启时，它被包含在正在执行此协程的线程名中。
 */
fun main() = runBlocking<Unit> {
    log("Started main coroutine")

    //运行两个后台值计算
    val v1 = async(CoroutineName("v1coroutine")) {
        delay(500)
        log("Computing v1")
        252
    }

    val v2 = async(CoroutineName("v2coroutine")) {
        delay(1000)
        log("Computing v2")
        6
    }

    log("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}