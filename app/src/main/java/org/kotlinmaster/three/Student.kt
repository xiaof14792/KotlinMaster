package org.kotlinmaster.three

class Student(name: String) {
    val name = name

    constructor(name: String, id: String) : this(name) {

    }

    constructor(name: String, id: String, sex: Int) : this(name, id) {

    }

    fun show() {
        println("Student: $name")
    }

    fun test() {
        val array: IntArray = intArrayOf(21, 40, 11, 33, 78)
        println("找出集合 {21, 40, 11, 33, 78} 中能够被 3 整除的所有元素：")


        val list = array.filter { i ->
            i % 3 == 0
        }
        println()
        list.forEach { i -> println(i) }
    }
}