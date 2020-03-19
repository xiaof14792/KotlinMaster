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


        /**
         * 数组和集合
         */
        var intArray = intArrayOf(1, 2, 3)
        var strList = listOf("a", "b", "c")

        //操作函数
        intArray.forEach { i ->
            println(i)
        }

        val newList = intArray.filter { i -> i != 0 }
        println(newList.size)

        //遍历集合中的每个元素，并执行对应表达式，并最终形成新的集合
        val newList2 = intArray.map { i -> i + 1 }

        //遍历每个元素，并为每个元素创建新的集合，最后合并到一个新的的集合中
        val newList3 = intArray.flatMap { i ->
            listOf("${i + 1}", "a")
        }
        print("--打印flatmap处理后的list：")
        newList3.forEach { s ->
            print(s + ", ")
        }

        /**
         * Range  Kotlin 中的 Range 表示区间的意思，也就是范围
         */
        var range: IntRange = 0..1000 //0到1000的范围，包括1000

        //半开区间的定义
        var range2 = 0 until 1000 //0到1000的范围，不包括1000

        //Range这个东西天生就是用来遍历的
        println("Range普通遍历：")
        for (i in range) {
            print("$i ,")
        }

        //还可以使用step设置步长
        println("step设置步长：")
        for (i in range step 3) {
            print("$i  ")
        }

        //还可以使用递减区间downTo，不过递减区间没有半开区间的用法
        println("递减区间downTo:")
        for (i in 4 downTo 0) {
            print("$i ")
        }


        /**
         * Sequence：惰性集合操作
         *
         */
        println("Sequence集合操作：")
        var sequence = sequenceOf(1, 2, 3, 4)

        var result = sequence
            .map { i ->
                println("Map $i")
                i * 2
            }.filter { j ->
                println("Filter $j")
                j % 3 == 0
            }

        println(result.first())

        /**
         * 1.一旦满足遍历退出的条件，就可以省略后续不必要的遍历过程
         * 2.像 List 这种实现 Iterable 接口的集合类，每调用一次函数就会生成一个新的 Iterable，
         * 下一个函数再基于新的 Iterable 执行，每次函数调用产生的临时 Iterable 会导致额外的内存消耗，
         * 而 Sequence 在整个流程中只有一个。
         *
         * 因此：Sequence这种数据类型可以在数据量比较大或者数据量未知时，作为一种流失处理的解决方案
         */


        /**
         * 条件控制
         */
        val a = 3
        val b = 9

        //Kotlin中if语句可以作为一个表达式赋值给变量
        val max = if (a > b) a else b//Kotlin中弃用了三元运算符，使用if-else替代

        //还可以是一个代码块，代码块的最后一行作为结果返回
        val max2 = if (a > b){
            println("max :  a")
            a
        }else{
            println("max : b")
            b
        }

        /**
         * when：相当于Java中的switch
         *
         * 不同点：
         * 1.省略了 case 和 break，前者比较好理解，后者的意思是 Kotlin 自动为每个分支加上了 break 的功能，防止我们像 Java 那样写错
         * 2.Java 中的默认分支使用的是 default 关键字，Kotlin 中使用的是 else
         */

        //在when语句中，还可以使用表达式作为分支的条件

        //使用in检查是否在某个区间或集合中
        when(a){
            in  1..10 -> print("a 在区间1..10中")

            in  listOf(1,2) -> print("a 在集合中")

            !in  10..20 -> print("不在区间10..20中")

            else -> print("不在任何集合中")
        }

        //或者使用is进行特定类型的检测
        var x = null
        val isString = when(x){
            is String -> true
            else -> false
        }

        //还可以省略when后面的参数，每个分支条件都可以是一个布尔表达式
        when{
            strList.contains("a") -> print("strList 包含 a")
            strList.size == 3 -> print("strList的大小为3")
        }


        /**
         * Kotlin 中的异常是不会被检查的，只有在运行时如果 sayHi 抛出异常，才会出错。
         */

        /**
         * ?.  ?:
         * Elvis 操作符 ?:
         * 我们知道空安全调用 ?.，在对象非空时会执行后面的调用，对象为空时就会返回 null。如果这时将该表达式赋值给一个不可空的变量，
         * 就可以使用Kotlin 中的 Elvis 操作符 ?: 来兜底：
         */

        var str: String? = "Hello"

        var length: Int = str?.length ?: -1

        fun validate(user: User){
            val str = user.name ?: return //验证user.name是否为null，为null则直接返回
        }


        /**
         * == 和 ===
         * ==  ：可以对基本数据类型以及String等类型进行数据比较，相当于Java中的equals
         * ===  ：对引用的内存地址进行比较，相当于Java中的==
         */

        println()
        val str1= "123"
        val str2 = "123"
        println(str1 == str2) //内容相等，输出：true

        val str3 = "abc"
        val str4 = str3
        val str5 = str3
        println(str4 === str5) //引用地址相等，输出true

        /**
         * 作业
         */
        val s = Student("allen")
        s.test()
    }
}