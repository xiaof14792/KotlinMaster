package org.kotlinmaster.courtines.cancel_timeout

import kotlinx.coroutines.*

/*
 * 我们有两种方法来使执行计算的代码可以被取消。第一种方法是定期调用挂起函数来检查取消。
 * 对于这种目的 yield 是一个好的选择。 另一种方法是显式的检查取消状态。让我们试试第二种方法。
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        val i = 0
        while (isActive) { //computation loop, just waste CPU
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: i am sleeping $i++")
                nextPrintTime += 500
            }
        }
    }

    delay(1300) //delay a bit
    println("main: i am tired of waiting")
    job.cancelAndJoin() //cancel the job and waits for its completion
    println("main: now, i can quit")

    /**
     * 你可以看到，现在循环被取消了。isActive 是一个可以被使用在 CoroutineScope 中的扩展属性。
     */
}