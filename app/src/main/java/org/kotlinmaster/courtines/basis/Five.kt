package org.kotlinmaster.courtines.basis

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch { doWorld() }
    println("Hello")
}


//我们将launch内部的代码块提取到独立的函数中，得到一个suspend修饰符的挂起函数
suspend fun doWorld(){
    delay(1000L)
    println("world!")
}