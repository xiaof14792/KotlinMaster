package com.example.officialpractice.coroutines.basis

import kotlinx.coroutines.*

fun main(){
    GlobalScope.launch { //在后台启动一个新的协程并继续
        delay(1000L)
        println("world")
    }

    println("hello") //协程在等待时主线程还在继续
//    Thread.sleep(2000) //阻塞主现场2s来保证JVM存活

    runBlocking {
        delay(2000L)
    }
    println(".")
}