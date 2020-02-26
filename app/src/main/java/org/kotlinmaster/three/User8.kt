package org.kotlinmaster.three

class User8(var name: String, var id: Int) {
    init {

    }

    constructor(person: Person) : this(person.name, person.id){

    }

    //总结一下类的初始化写法：

    /**
     * 1.首先创建一个 User 类：
     *
     * 2.添加一个参数为 name 与 id 的主构造器：
     *
     * 3.主构造器中的 name 与 id 声明为类的属性：
     *
     * 4.然后在 init 代码块中添加一些初始化逻辑：
     *
     * 5.最后再添加其他次构造器：
     *
     * 一个类有多个构造器时，只需要把最基本、最通用的那个写成主构造器就行了。这里我们选择将参数为 name 与 id 的构造器作为主构造器。
     */
}