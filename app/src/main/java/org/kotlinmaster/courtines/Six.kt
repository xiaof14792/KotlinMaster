package org.kotlinmaster.courtines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    //协程很轻量
    repeat(1000_000){ //启动1000000个协程
        launch {
            delay(1000L)
            println(Thread.currentThread().name)
        }
    }
}