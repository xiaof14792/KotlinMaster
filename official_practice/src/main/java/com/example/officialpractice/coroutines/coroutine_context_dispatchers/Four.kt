package com.example.officialpractice.coroutines.coroutine_context_dispatchers

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 在不同线程间跳转
 *
 * 其中一个使用 runBlocking 来显式指定了一个上下文，并且另一个使用 withContext 函数来改变协程的上下文，而仍然驻留在相同的协程中
 *
 * 当我们不再需要某个在 newSingleThreadContext 中创建的线程的时候， 它使用了 Kotlin 标准库中的 use 函数来释放该线程。
 */
fun main() = runBlocking<Unit> {

    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                log("started in ctx1")
                withContext(ctx2) {
                    log("working in ctx2")
                }
                log("back to ctx1")
            }
        }
    }
}