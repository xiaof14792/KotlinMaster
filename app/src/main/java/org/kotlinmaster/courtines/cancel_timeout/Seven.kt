package org.kotlinmaster.courtines.cancel_timeout

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * 由于取消只是一个例外，所有的资源都使用常用的方法来关闭。 如果你需要做一些各类使用超时的特别的额外操作，
 * 可以使用类似 withTimeout 的 withTimeoutOrNull 函数，并把这些会超时的代码包装在
 * try {...} catch (e: TimeoutCancellationException) {...} 代码块中，而 withTimeoutOrNull 通过返回 null 来进行超时操作，
 * 从而替代抛出一个异常：
 */
fun main() = runBlocking {
    val result = withTimeoutOrNull(1300){
        repeat(1000){i ->
            println("i am sleeping $i")
            delay(500)
        }
        "result" //will get canceled before it produces this result
    }

    println("result:$result")
}