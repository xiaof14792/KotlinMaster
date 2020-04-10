package com.example.officialpractice.coroutines.coroutine_context_dispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * 调度器与线程
 */
fun main() = runBlocking<Unit> {
    launch {//运行在父协程的上下文中，即runBlocking主协程
        println("main runBlocking,       I am workong in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {//不受限的-将工作在主协程中
        println("Unconfined,       I am workong in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {//将会获取默认调度器，运行在后台线程池中
        println("Default,       I am workong in thread ${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("MyOwnThread")) {//将使它获得一个新的线程
        println("newSingleThreadContext,       I am workong in thread ${Thread.currentThread().name}")
    }
}