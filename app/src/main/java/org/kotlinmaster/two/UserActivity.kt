package org.kotlinmaster.two

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.kotlinmaster.two.library1.method

class UserActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //object写匿名内部类
        val view: View = View(this)
        view.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        //Kotlin 中 object: 也可以用来创建匿名类的对象
        //修饰的都是接口或者抽象类。

        //
        A.B.c
        A.d

        /**
         * top-level property/ function声明
         */

        //可以看到当出现两个同名顶级函数时，IDE 会自动加上包前缀来区分，这也印证了「顶级函数属于包」的特性。
        method()
        org.kotlinmaster.two.library2.method()


        /**
         * 对比：
         * 那在实际使用中，在 object、companion object 和 top-level 中该选择哪一个呢？简单来说按照下面这两个原则判断：
         *
         * 1。如果想写工具类的功能，直接创建文件，写 top-level「顶层」函数。
         * 2。如果需要继承别的类或者实现接口，就用 object 或 companion object。
         */


        /**
         * 常量
         */

        /**
         * 数组和集合
         */

        //数组

        var strs: Array<String> = arrayOf("a", "b", "c")
        //Kotlin 中的数组是一个拥有泛型的类，创建函数也是泛型函数，和集合数据类型一样。
        //将数组泛型化有什么好处呢？对数组的操作可以像集合一样功能更强大，由于泛型化，Kotlin 可以给数组增加很多有用的工具函数：
        strs.first()
        strs.contains("Y")

        //取值和修改
        println(strs[0])

        strs[1] = "B"

        //不支持协变
//        val anys: Array<Any> = strs
        //Kotlin 的数组编译成字节码时使用的仍然是 Java 的数组，但在语言层面是泛型实现，这样会失去协变 (covariance) 特性
        //就是子类数组对象不能赋值给父类的数组变量


        //集合

        //新建list
        val strList = listOf("a", "b", "c")

        //Kotlin 中的 List 多了一个特性：支持 covariant（协变）。也就是说，可以把子类的 List 赋值给父类的 List 变量：
        val anyList = strList

        //对于协变的支持与否，kotlin与JavaList 和数组刚好反过来了
        //Kotlin 中数组和 MutableList 的 API 是非常像的，主要的区别是数组的元素个数不能变。那在什么时候用数组呢？

        //1。这个问题在 Java 中就存在了，数组和 List 的功能类似，List 的功能更多一些，直觉上应该用 List 。
        // 但数组也不是没有优势，基本类型 (int[]、float[]) 的数组不用自动装箱，性能好一点。

        //2。在 Kotlin 中也是同样的道理，在一些性能需求比较苛刻的场景，并且元素类型是基本类型时，用数组好一点。
        // 不过这里要注意一点，Kotlin 中要用专门的基本类型数组类 (IntArray FloatArray LongArray) 才可以免于装箱。也就是说元素不是基本类型时，相比 Array，用 List 更方便些。


        //新建set
        var strSet = setOf("a", "b", "c")
        //和 List 类似，Set 同样具有 covariant（协变）特性。

        //新建map
        val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 3)


        //取值和修改
        val value1 = map.get("key1")
        val value2 = map["key2"]

        val map2 = mutableMapOf("key1" to 1, "key2" to 2)
        map2.set("key1", 1)
        map2["key2"] = 1


        //可变集合/不可变集合

        //Kotlin 中集合分为两种类型：只读的和可变的。这里的只读有两层意思：
        //1。集合的 size 不可变
        //2。集合中的元素值不可变

        /**
         *
        listOf() 创建不可变的 List，mutableListOf() 创建可变的 List。
        setOf() 创建不可变的 Set，mutableSetOf() 创建可变的 Set。
        mapOf() 创建不可变的 Map，mutableMapOf() 创建可变的 Map
         */

        //可以看到，有 mutable 前缀的函数创建的是可变的集合，没有 mutbale 前缀的创建的是不可变的集合，
        // 不过不可变的可以通过 toMutable*() 系函数转换成可变的集合

        strList.toMutableList()

        strSet.toMutableSet()

        val mutableMap = map.toMutableMap()

        //toMutable*() 返回的是一个新建的集合，原有的集合还是不可变的，所以只能对函数返回的集合修改。
        mutableMap.set("key1", 9)

        /**
         * Sequence
         */
        //Kotlin 还引入了一个新的容器类型 Sequence，它和 Iterable 一样用来遍历一组数据并可以对每个元素进行特定的处理

        //创建

        //使用一组元素创建：
        sequenceOf("a", "b", "c")

        //使用 Iterable 创建：
        val list = listOf("a", "b", "c")
        list.asSequence()


        //使用 lambda 表达式创建：
        val sequence = generateSequence(0) { it + 1 }
        //第一个元素   //ambda 表达式，负责生成第二个及以后的元素，it 表示前一个元素


        /**
         * 可见性修饰符
         */

        //Kotlin 中如果不写可见性修饰符，就表示公开，和 Java 中 public 修饰符具有相同效果。
        // 在 Kotlin 中 public 修饰符「可以加，但没必要」。


        //@hide
        //在 Android 的官方 sdk 中，有一些方法只想对 sdk 内可见，不想开放给用户使用
        //但这种限制不太严格，可以通过反射访问到限制的方法。针对这个情况，Kotlin 引进了一个更为严格的可见性修饰符：internal。


        //internal
        //internal 表示修饰的类、函数仅对 module 内可见，这里的 module 具体指的是一组共同编译的 kotlin 文件

        //internal 在写一个 library module 时非常有用，当需要创建一个函数仅开放给 module 内部使用，
        // 不想对 library 的使用者可见，这时就应该用 internal 可见性修饰符。

        /**
         * Java 的「包内可见」怎么没了？
         */

        //Java 的 default「包内可见」在 Kotlin 中被弃用掉了，Kotlin 中与它最接近的可见性修饰符是 internal「module 内可见」。
        // 为什么会弃用掉包内可见呢？我觉得有这几个原因：

        /**
         * 1.Kotlin 鼓励创建 top-level 函数和属性，一个源码文件可以包含多个类，使得 Kotlin 的源码结构更加扁平化，包结构不再像 Java 中那么重要。
         *
         * 2.为了代码的解耦和可维护性，module 越来越多、越来越小，使得 internal 「module 内可见」已经可以满足对于代码封装的需求。
         */


        //protected

        //Kotlin 相比 Java protected 的可见范围收窄了，原因是 Kotlin 中不再有「包内可见」的概念了，
        // 相比 Java 的可见性着眼于 package，Kotlin 更关心的是 module。


        //private

        /**
         * Java 中的 private 表示类中可见，作为内部类时对外部类「可见」。
         *
         * Kotlin 中的 private 表示类中或所在文件内可见，作为内部类时对外部类「不可见」。
         */

        //private 修饰的变量「类中可见」和 「文件中可见」:

        /**
         * 在 Java 中，外部类可以访问内部类的 private 变量：
         *
         * 在 Kotlin 中，外部类不可以访问内部类的 private 变量：
         */


        //可以修饰类和接口
        /**
         * Java 中一个文件只允许一个外部类，所以 class 和 interface 不允许设置为 private，因为声明 private 后无法被外部使用，这样就没有意义了。
         *
         * Kotlin 允许同一个文件声明多个 class 和 top-level 的函数和属性，所以 Kotlin 中允许类和接口声明为 private，因为同个文件中的其它成员可以访问：
         */


        //练习题
        Kotlin.Inner.newInstance()

        Kotlin.newInstance()

        Kotlin.Inner().newInstance()

//        val kotlin = Kotlin()


        test()
    }

    class Outer{

        fun method(){
            val inner  = Inner()

//            val result = inner.number * 2 //在 Kotlin 中，外部类不可以访问内部类的 private 变量
        }

        class Inner{
            private val number = 1
        }
    }
}