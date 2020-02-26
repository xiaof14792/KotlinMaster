package org.kotlinmaster.three

/**
 * 如果类中有主构造器，那么其他的次构造器都需要通过 this 关键字调用主构造器，可以直接调用或者通过别的次构造器间接调用,如果不调用 IDE 就会报错：
 */

class User4 constructor(name: String) {

    //直接调用祝构造器
    constructor(name: String, id: Int) : this(name){

    }

    //通过上一个构造器，直接调用主构造器
    constructor(name: String, id: Int, age: Int) : this(name, id){

    }

    /**
     * 为什么当类中有主构造器的时候就强制要求次构造器调用主构造器呢？
     * 我们从主构造器的特性出发，一旦在类中声明了主构造器，就包含两点：
     *
     * 1.必须性：创建类的对象时，不管使用哪个构造器，都需要主构造器的参与
     * 2.第一性：在类的初始化过程中，首先执行的就是主构造器
     *
     * 这也就是主构造器的命名由来
     */

    //在使用次构造器创建对象时，init 代码块是先于次构造器执行的。如果把主构造器看成身体的头部，
    // 那么 init 代码块就是颈部，次构造器就相当于身体其余部分。

    /**
     * 细心的你也许会发现这里又出现了 : 符号，它还在其他场合出现过，例如：
     *
     * 变量的声明：var id: Int
     * 类的继承：class MainActivity : AppCompatActivity() {}
     * 接口的实现：class User : Impl {}
     * 匿名类的创建：object: ViewPager.SimpleOnPageChangeListener() {}
     * 函数的返回值：fun sum(a: Int, b: Int): Int
     */

    //可以看出 : 符号在 Kotlin 中非常高频出现，它其实表示了一种依赖关系，在这里表示依赖于主构造器。



}

//通常情况下，主构造器中的 constructor 关键字可以省略：
class User5(name: String){

}

//但有些场景，constructor 是不可以省略的，例如在主构造器上使用「可见性修饰符」或者「注解」：
class User6 private constructor(name: String) {
//           👆 主构造器被修饰为私有的，外部就无法调用该构造器
}