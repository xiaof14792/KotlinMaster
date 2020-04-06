package com.example.officialpractice.coroutines.composing_suspending_functinos

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 惰性启动的async
 * 可选的，async 可以通过将 start 参数设置为 CoroutineStart.LAZY 而变为惰性的。 在这个模式下，只有结果通过 await 获取的时候协程才会启动，或者在 Job 的 start 函数调用的时候。
 * 注意，如果我们只是在 println 中调用 await，而没有在单独的协程中调用 start，这将会导致顺序行为，
 * 直到 await 启动该协程 执行并等待至它结束，这并不是惰性的预期用例
 */
fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        one.start() //必须先在单独的协程中调用start，不然会导致顺序行为
        two.start()
        println("the answer is ${one.await() + two.await()}")
    }
    println("completed in $time ms")
}
