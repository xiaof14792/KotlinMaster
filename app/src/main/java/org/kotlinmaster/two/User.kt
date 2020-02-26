package org.kotlinmaster.two

class User {
    val id: Int
    val name: String

    //初始化代码块，先于下面的构造器执行
    init {
        println("初始化代码块，先于下面的构造器执行")
    }

    constructor(id: Int, name: String){
        this.id = id
        this.name = name
    }
}