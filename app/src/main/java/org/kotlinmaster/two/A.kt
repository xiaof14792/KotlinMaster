package org.kotlinmaster.two

class A {
    //用 object 修饰的对象中的变量和函数都是静态的，但有时候，我们只想让类中的一部分函数和变量是静态的该怎么做呢：
    object B{
        val c: Int = 0
    }

    //companion 可以理解为伴随、伴生，表示修饰的对象和外部类绑定。
    //当有 companion 修饰时，对象的名字也可以省略掉：
    companion object {
        // Java 中的静态初始化在 Kotlin 中自然也是放在 companion object 中的，像类的初始化代码一样，由 init 和一对大括号表示：
        init {
            println("静态初始化")
        }


        val d: Int = 1
    }


}