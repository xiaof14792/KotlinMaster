package org.kotlinmaster.two


/**
 * 练习二
 */
fun test(){
    val array: Array<Int> = Array(100000, init = {it -> it + 1})

    val intArray: IntArray = IntArray(100000, {i -> i + 1})

    val list: List<Int> = List(100000, {i -> i + 1})

    //
    var startTime: Long = System.nanoTime()
    var sum: Long = 0
    for (a in array){
        sum = sum + a
    }
    var avl: Double = sum * 1.0 / 100000
    var endTime: Long = System.nanoTime()

    println("--array avl:" + avl + "; 时间：" + (endTime - startTime))


    //
    startTime = System.nanoTime()
    sum = 0
    for (a in intArray){
        sum = sum + a
    }
    avl = sum * 1.0/ 100000
    endTime = System.nanoTime()

    println("--intArray avl:" + avl + "; 时间：" + (endTime - startTime))


    //
    startTime = System.nanoTime()
    sum = 0
    for (a in list){
        sum = sum + a
    }
    avl = sum * 1.0/ 100000
    endTime = System.nanoTime()

    println("--list avl:" + avl + "; 时间：" + (endTime - startTime))
}