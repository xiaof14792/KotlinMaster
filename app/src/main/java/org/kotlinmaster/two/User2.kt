package org.kotlinmaster.two

import android.view.View

class User2(var id: Int, var name: String) {
    /**
     * final
     */

    val final1 = 1

    //Kotlin 函数参数默认是 val 类型，所以参数前不需要写 val 关键字，保证了参数不会被修改
    fun method(final2: String){
        val final3 = "The parameter is " + final2
    }

    val items = listOf(1,23,4,5)
    /**
     * val自定义getter
     */
    //虽然 val 修饰的变量不能二次赋值，但可以通过自定义变量的 getter 函数，让变量每次被访问时，返回动态获取的值：
    //大部分情况下 val 还是对应于 Java 中的 final 使用的。
    val size: Int
    get() {
        return items.size
    }


    /**
     * static property/function
     */
    //更复杂了？
    companion object{
        val anotherString = "Another String"
    }

    /**
     * object
     */
    //创建一个类，并且创建一个这个类的对象。这个就是 object 的意思：对象。
    object Sample{
        val name = "A name"
    }

    fun test1(){
        Sample.name //直接通过它的类名就可以访问
    }

    //单例实现
    object A{
        val number: Int = 1
        fun method(){
            println("A.method()")
        }

    }
    // object 实现的单例是一个饿汉式的单例，并且实现了线程安全。


    //Kotlin 中不仅类可以继承别的类，可以实现接口，object 也可以：
    open class B{
        open fun method(){

        }
    }

    interface C{
        fun interfaceMethod()
    }

    object D : B(),C{
        override fun method() {
            super.method()
        }

        override fun interfaceMethod() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
    //为什么 object 可以实现接口呢？简单来讲 object 其实是把两步合并成了一步，既有 class 关键字的功能，又实现了单例，这样就容易理解了。


}