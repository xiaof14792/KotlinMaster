package org.kotlinmaster.courtines.basis

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { //this: CoroutineScope
    launch {
        delay(200L)
        println("task from runBlocking")
    }

    //coroutineScope会创建一个协程作用域，并且在所有已启动子协程执行完毕之前不会结束

    coroutineScope { //Creates a coroutine scope 创建一个协程作用域
        launch {
            delay(500)
            println("task from nested launch")
        }

        delay(100)
        println("task from coroutine scope")
    }

    println("coroutine scope is over") //这一行会在内嵌launch执行完成之后才输出
}