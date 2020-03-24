package org.kotlinmaster.courtines.cancel_timeout

import kotlinx.coroutines.*

/**
 * 在前一个例子中任何尝试在 finally 块中调用挂起函数的行为都会抛出 CancellationException，
 * 因为这里持续运行的代码是可以被取消的。
 */
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(5000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并等待它结束
    println("main: Now I can quit.")

    /**
     * 当你需要挂起一个被取消的协程，你可以将相应的代码包装在 withContext(NonCancellable) {……} 中，
     * 并使用 withContext 函数以及 NonCancellable 上下文
     */
}