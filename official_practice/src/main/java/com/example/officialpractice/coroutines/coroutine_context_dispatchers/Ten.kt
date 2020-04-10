package com.example.officialpractice.coroutines.coroutine_context_dispatchers


import kotlinx.coroutines.*

/**
 * 线程局部数据
 *
 * ThreadLocal， asContextElement 扩展函数在这里会充当救兵。它创建了额外的上下文元素，
 * 且保留给定 ThreadLocal 的值，并在每次协程切换其上下文时恢复它。
 */

val threadLocal = ThreadLocal<String?>()

fun main() = runBlocking<Unit> {
    threadLocal.set("main")

    println("pre main: current thread: ${Thread.currentThread()} + thread local value: ${threadLocal.get()}")
    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
        println("Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        yield()
        println("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    }

    job.join()
    println("post main: current thread: ${Thread.currentThread()} + thread local value: ${threadLocal.get()}")
}