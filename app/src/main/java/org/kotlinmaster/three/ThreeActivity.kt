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
    }
}