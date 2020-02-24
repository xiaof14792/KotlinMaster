package org.kotlinmaster

class User {
    var name: String? = null //可空类型
    //name可以为null，解除了它的非空限制
    get() {
        return field + " nb" //上面的的那个 String name 就是 Kotlin 帮我们自动创建的一个 Java field。
        // 这个 field 对编码的人不可见，但会自动应用于 getter 和 setter，因此它被命名为「Backing Field」
        // 它相当于每一个 var 内部的一个变量。
    }
    set(value) {
        field = "cute " + value
    }

    val name2 = "Mike"
    get() {
        return field
    }
//    set(value) {
//        field = name2
//    }


}