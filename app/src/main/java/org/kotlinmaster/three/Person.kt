package org.kotlinmaster.three

import java.lang.IllegalArgumentException

class Person(val name: String, val id: Int) {
    /**
     * 函数简化
     */

    //使用=连接返回值
    fun area(width: Int, height: Int): Int = width * height
    //{} 和 return 没有了，使用 = 符号连接返回值。


    fun area2(width: Int, height: Int) = width * height
    //Kotlin 有「类型推断」的特性，那么这里函数的返回类型还可以隐藏掉：

    //对于没有返回值的情况，可以理解为返回值是 Unit：
    fun sayHi(name: String){
        println("Hi " + name)
    }

    fun sayHi2(name: String) = println("Hi " + name)


    //参数默认值
    /**
     * Java 中，允许在一个类中定义多个名称相同的方法，但是参数的类型或个数必须不同，这就是方法的重载：
     *
     * 在 Kotlin 中，也可以使用这样的方式进行函数的重载，不过还有一种更简单的方式，那就是「参数默认值」：
     */
    fun sayHi3(name: String = "World"){
        println("Hello " + name)
    }
    //这里的 world 是参数 name 的默认值，当调用该函数时不传参数，就会使用该默认值。

    //其实在 Java 中，每个重载方法的内部实现可以各不相同，这就无法保证重载方法内部设计上的一致性，而 Kotlin 的参数默认值就解决了这个问题。


    //命名参数
    fun sayHi4(name: String = "world", age: Int){

    }

    //再来看一个有非常多参数的函数的例子：
    fun sayHi5(name: String = "world", age: Int, isStudent: Boolean, isFat: Boolean, isTall: Boolean){

    }

    //位置参数

    //与命名参数相对的一个概念被称为「位置参数」，也就是按位置顺序进行参数填写。


    //本地函数（嵌套函数）
    fun login(username: String, password: String, illegalStr: String){
        // 验证 username 是否为空
        if (username.isEmpty()){
            throw IllegalArgumentException(illegalStr)
        }

        // 验证 password 是否为空
        if (username.isEmpty()){
            throw IllegalArgumentException(illegalStr)
        }
    }
    //该函数中，检查参数这个部分有些冗余，我们又不想将这段逻辑作为一个单独的函数对外暴露。
    //这时可以使用嵌套函数，在 login 函数内部声明一个函数：

    fun login2(username: String, password: String, illegalStr: String){
        fun valid(value: String, illegalStr: String){
            if (value.isEmpty()){
                throw IllegalArgumentException(illegalStr)
            }
        }

        valid(username,illegalStr)
        valid(password, illegalStr)
    }
    //这里我们将共同的验证逻辑放进了嵌套函数 validate 中，并且 login 函数之外的其他地方无法访问这个嵌套函数。


    //这里的 illegalStr 是通过参数的方式传进嵌套函数中的，其实完全没有这个必要，
    // 因为嵌套函数中可以访问在它外部的所有变量或常量，例如类中的属性、当前函数中的参数与变量等。

    //可以稍加改进：
    fun login3(username: String, password: String, illegalStr: String){
        fun valid(value: String){
            if (value.isEmpty()){
                throw IllegalArgumentException(illegalStr)
            }
        }

        valid(username)
        valid(password)
    }
    //这里省去了嵌套函数中的 illegalStr 参数，在该嵌套函数内直接使用外层函数 login 的参数 illegalStr。



    //上面 login 函数中的验证逻辑，其实还有另一种更简单的方式：
    fun login4(username: String, password: String, illegalStr: String) {
        require(username.isNotEmpty()){ illegalStr }
        require(password.isNotEmpty()){ illegalStr }
    }
    //其中用到了 lambda 表达式以及 Kotlin 内置的 require 函数





}