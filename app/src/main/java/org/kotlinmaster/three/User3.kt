package org.kotlinmaster.three


//主构造器中的参数除了可以在类的属性中使用，还可以在 init 代码块中使用：
class User3 constructor(name: String) {
    var name: String
    init {
        this.name = name
    }

    //其中 init 代码块是紧跟在主构造器之后执行的，这是因为主构造器本身没有代码体，init 代码块就充当了主构造器代码体的功能。
}