package com.example.officialpractice.coroutines.composing_suspending_functinos

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.ArithmeticException

/**
 * 这种情况下，如果在 failedConcurrentSum 函数内部发生了错误，并且它抛出了一个异常， 所有在作用域中启动的协程都会被取消。
 */
fun main() = runBlocking<Unit> {
    try {
        failedConcurrentSum()
    }catch (e: ArithmeticException){
        println("computation failed with ArithmeticException")
    }
}

suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE)
            42
        }finally {
            println("first child was cancelled")
        }
    }

    val two = async<Int> {
        println("second child throws an exception")
        throw ArithmeticException()
    }

    one.await() + two.await()
}