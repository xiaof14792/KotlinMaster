package com.example.officialpractice.coroutines.coroutine_context_dispatchers


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 子协程
 *
 * 当一个协程被其它协程在 CoroutineScope 中启动的时候， 它将通过 CoroutineScope.coroutineContext 来承袭上下文，
 * 并且这个新协程的 Job 将会成为父协程作业的 子 作业。当一个父协程被取消的时候，所有它的子协程也会被递归的取消。
 */
fun main() = runBlocking<Unit> {
    //启动一个协程来处理某种传入请求（request）
    val request = launch {

        //孵化来两个子作业，其中一个通过GlobalScope来启动
        GlobalScope.launch {
            println("job1: I run in GlobalScope and execute independently!")
            delay(1000)
            println("job1: I am not affected by cancellation of the request")
        }

        //另一个则承袭来父协程的上下文
        launch {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }

    delay(500)
    request.cancel() //取消请求（request）的执行
    delay(1000) //延迟了1秒钟来看看发生了什么
    println("main: Who has survived request cancellation?")
}