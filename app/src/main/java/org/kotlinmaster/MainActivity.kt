package org.kotlinmaster

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.Nullable
import java.lang.StringBuilder

open class MainActivity : AppCompatActivity() {

    lateinit var viewContent: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var view: View? = null //可空类型
        view = findViewById(R.id.view_content)
        view?.setBackgroundColor(Color.RED) //safe call

        view!!.setBackgroundColor(Color.GRAY) //non-null asserted call 非空断言式的调用


        //Java 里面的 @Nullable 注解，在 Kotlin 里调用时同样需要使用 "?."。

        //Java 里面的 @Nullable 和 @NonNull 注解，在转换成 Kotlin 后对应的就是可空变量和不可空变量
        val name1: String? = null
        val name2: String = "apple"


        //我很确定我用的时候绝对不为空，但第一时间我没法给它赋值:[延迟赋值]
        //它的作用就是让 IDE 不要对这个变量检查初始化和报错。换句话说，加了这个 lateinit 关键字，这个变量的初始化就全靠你自己了，编译器不帮你检查了。
        viewContent = findViewById(R.id.view_content);


        /**
         * 类型判断
         */
        var name3: String = "Mike"
        var name4 = "Mike" //类型推断

        //「动态类型」是指变量的类型在运行时可以改变；而「类型推断」是你在代码里不用写变量类型，编译器在编译的时候会帮你补上。
        // 因此，Kotlin 是一门静态语言。

        //val和var
        val size = 10//只读变量。它只能赋值一次，不能修改

        //value variable

        /**
         * 函数
         */
        var myName1: String? = "fangxiang"
        var myName2: String = "fangxiang"
        fun cook(name: String): Food {
            return Food()
        }

        fun cook(name: String?): Food {
            return Food()
        }

        //可空变量传给不可空参数，报错
//        cook(myName1)

        //可空变量传给可空参数，正常运行
        cook(myName1)

        //不可空变量传给不可空参数，正常运行
        cook(myName2)


        /**
         * 属性的getter/setter函数
         */
        var user: User = User()
        user.name = "Mary" //实际是这么调用的：setName("Mary")

        println(user.name) //实际是这么调用的：println(getName())


        /**
         * 类型
         */
        //在Kotlin，Int 是否装箱根据场合来定：
        var a: Int = 1 // unbox
        var b: Int? = 2 // box
        var list: List<Int> = listOf(1, 2) // box

        var array: IntArray = intArrayOf(1, 2)
        // 👆这种也是 unbox 的
        /**
        简单来说，原先在 Java 里的基本类型，类比到 Kotlin 里面，条件满足如下之一就不装箱：

        1,不可空类型。
        2,使用 IntArray、FloatArray 等。
         */

        /**
         * 类和对象
         */

        /**
         * 类型的判断和强转
         */

    }

    open fun test(){

    }
}
