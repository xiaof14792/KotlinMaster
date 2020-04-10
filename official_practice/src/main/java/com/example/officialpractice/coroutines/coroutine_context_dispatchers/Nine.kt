package com.example.officialpractice.coroutines.coroutine_context_dispatchers


import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 组合上下文中的元素
 * 有时我们需要在协程上下文中定义多个元素。我们可以使用 + 操作符来实现。
 *
 */
fun main() = runBlocking<Unit> {
    //比方说，我们可以显示指定一个调度器来启动协程并且同时显式指定一个命名
    launch(Dispatchers.IO + CoroutineName("test")) {
        println("I am working in thread ${Thread.currentThread().name}")
    }
}