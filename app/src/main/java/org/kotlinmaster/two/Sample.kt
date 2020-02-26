package org.kotlinmaster.two

class Sample {
    companion object{
        const val CONST_NUMBER = 1
    }
}

const val CONST_SECOND_NUMBER = 2

//1.Kotlin 的常量必须声明在对象（包括伴生对象）
//2.或者「top-level 顶层」中，因为常量是静态的。




//Kotlin 中只有基本类型和 String 类型可以声明成常量。

//原因是 Kotlin 中的常量指的是 「compile-time constant 编译时常量」，它的意思是「编译器在编译的时候就知道这个东西在每个调用处的实际值」，因此可以在编译时直接把这个值硬编码到代码里使用的地方。
//而非基本和 String 类型的变量，可以通过调用对象的方法或变量改变对象内部的值，这样这个变量就不是常量了