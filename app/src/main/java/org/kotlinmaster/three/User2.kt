package org.kotlinmaster.three

//主构造器
class User2 constructor(name: String) {

    var name: String = name

    //不同点：
    //1。constructor 构造器移到了类名之后
    //2。类的属性 name 可以引用构造器中的参数 name

    /**
     * 这个写法叫「主构造器 primary constructor」。与之相对的在第二篇中，写在类中的构造器被称为「次构造器」。
     * 在 Kotlin 中一个类最多只能有 1 个主构造器（也可以没有），而次构造器是没有个数限制。
     */
}