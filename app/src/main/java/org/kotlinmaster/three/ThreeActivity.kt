package org.kotlinmaster.three

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val person: Person = Person("fangxiang", 17)
        person.sayHi3("kaixue.io")
        person.sayHi3() //使用了默认值"world"


        person.sayHi4(age = 21)
        //在调用函数时，显式地指定了参数 age 的名称，这就是「命名参数」。Kotlin 中的每一个函数参数都可以作为命名参数。


        //当函数中有非常多的参数时，调用该函数就会写成这样：
        person.sayHi5("world", 17, false, true, true)

        //当看到后面一长串的布尔值时，我们很难分清楚每个参数的用处，可读性很差。通过命名参数，我们就可以这么写：
        person.sayHi5(name = "world", age = 17, isStudent = false, isFat = true, isTall = true)


        //当一个函数被调用时，如果混用位置参数与命名参数，那么所有的位置参数都应该放在第一个命名参数之前：
//        person.sayHi4(name = "wo", 17) error
        person.sayHi4("wo", age = 17)


        /**
         * 字符串
         */
        //字符串模版

        //在 Java 中，字符串与变量之间是使用 + 符号进行拼接的

        val name2 = "world"
        //用'$'符号加参数的方式
        println("Hello $name2")
        //这种方式就是把 name 从后置改为前置，简化代码的同时增加了字符串的可读性。

        //除了变量，$ 后还可以跟表达式，但表达式是一个整体，所以我们要用 {} 给它包起来：
        println("Hello ${name2.length}")
        //其实就跟四则运算的括号一样，提高语法上的优先级，而单个变量的场景可以省略 {}。

        //字符串模板还支持转义字符，比如使用转义字符 \n 进行换行操作：
        val name3 = "World\n"
        println("hello $name3") //会多打一个空行



        //raw string （原生字符串）

        //有的时候我们不希望写过多的转义字符，这种情况 Kotlin 通过「原生字符串」来实现。
        val myName = "kotlin"

        val text = """
            Hi, $name2,
              My name is $myName\n
        """
        println(text)

        //这里有几个注意点：
        /**
         * 1.\n 并不会被转义
         * 2.最后输出的内容与写的内容完全一致，包括实际的换行
         * 3.$ 符号引用变量仍然生效
         */


        //原生字符串还可以通过 trimMargin() 函数去除每行前面的空格：
        val text2 = """
            |Hello, $name2,
              |My name is $myName\n
        """.trimMargin()
        println(text2)
        //trimMargin() 函数有以下几个注意点：
        /**
         * 1.| 符号为默认的边界前缀，前面只能有空格，否则不会生效
         * 2.输出时 | 符号以及它前面的空格都会被删除
         * 3.边界前缀还可以使用其他字符，比如 trimMargin("/")，只不过上方的代码使用的是参数默认值的调用方式
         */

    }
}