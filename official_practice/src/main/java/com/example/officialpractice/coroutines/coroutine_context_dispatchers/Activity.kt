package com.example.officialpractice.coroutines.coroutine_context_dispatchers

import kotlinx.coroutines.*

/**
 * 协程作用域
 *
 * 我们通过创建一个 CoroutineScope 实例来管理协程的生命周期，并使它与 activit 的生命周期相关联。
 *
 * 我们可以在这个 Activity 类中实现 CoroutineScope 接口。最好的方法是使用具有默认工厂函数的委托。
 * 我们也可以将所需的调度器与作用域合并（我们在这个示例中使用 Dispatchers.Default）。
 */
class Activity : CoroutineScope by CoroutineScope(Dispatchers.Default) {

    fun destroy(){
        cancel()
    }

    // 在 Activity 类中
    fun doSomething() {
        // 在示例中启动了 10 个协程，且每个都工作了不同的时长
        repeat(10) { i ->
            launch {
                delay((i + 1) * 200L) // 延迟 200 毫秒、400 毫秒、600 毫秒等等不同的时间
                println("Coroutine $i is done")
            }
        }
    }

}

fun main() = runBlocking<Unit> {
    val activity = Activity()
    activity.doSomething() // 运行测试函数
    println("Launched coroutines")
    delay(500L) // 延迟半秒钟
    println("Destroying activity!")
    activity.destroy() // 取消所有的协程
    delay(1000) // 为了在视觉上确认它们没有工作
}