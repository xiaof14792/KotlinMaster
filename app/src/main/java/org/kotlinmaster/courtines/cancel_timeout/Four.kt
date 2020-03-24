package org.kotlinmaster.courtines.cancel_timeout

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 我们通常使用如下的方法处理在被取消时抛出 CancellationException 的可被取消的挂起函数。
 */
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000){i ->
                println("job: i am sleeping $i")
                delay(500)
            }
        }finally {
            println("job: i am running finally")
        }

    }

    delay(1300)
    println("main: i am tired of waiting")
    job.cancelAndJoin()
    println("main: now, i can quit")

    /**
     * join 和 cancelAndJoin 等待了所有的终结动作执行完毕， 所以运行示例得到了下面的输出：
     */
}