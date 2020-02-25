package org.kotlinmaster.one

import android.os.Bundle

class Main2Activity private constructor(name: String): MainActivity(),
    Impl {
    //Java 里面 @Override 是注解的形式。
    //Kotlin 里的 override 变成了关键字。
    //Kotlin 省略了 protected 关键字，也就是说，Kotlin 里的 override 函数的可见性是继承自父类的

    //onCreate 仍然是 override 的，加了 final 关键字，作用和 Java 里面一样，关闭了 override 的遗传性
    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //也有和 Java 一样的 abstract 关键字，这俩关键字的区别就是 abstract 关键字修饰的类无法直接实例化，
    // 并且通常来说会和 abstract 修饰的函数一起出现，当然，也可以没有这个 abstract 函数。
}