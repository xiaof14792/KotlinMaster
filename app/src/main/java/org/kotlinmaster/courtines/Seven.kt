package org.kotlinmaster.courtines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    //在GlobalScope中启动的活动协程并不会使进程包活。它们就像守护线程

    GlobalScope.launch { //启动一个新的全局协程
        repeat(1000){ i ->
            println("I am sleeping $i")
            delay(500L)
        }
    }

    delay(1300L) //在延迟1300ms后退出
}