package org.kotlinmaster.courtines.cancel_timeout

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/**
 * 在实践中绝大多数取消一个协程的理由是它有可能超时。 当你手动追踪一个相关 Job 的引用并启动了一个单独的协程在延迟后取消追踪，
 * 这里已经准备好使用 withTimeout 函数来做这件事。
 */
fun main() = runBlocking {
    withTimeout(1300){
        repeat(1000){i ->
            println("i am sleeping $i")
            delay(500)
        }
    }

    /**
     * withTimeout 抛出了 TimeoutCancellationException，它是 CancellationException 的子类。
     * 我们之前没有在控制台上看到堆栈跟踪信息的打印。这是因为在被取消的协程中 CancellationException 被认为是协程执行结束的正常原因。
     * 然而，在这个示例中我们在 main 函数中正确地使用了 withTimeout。
     */
}