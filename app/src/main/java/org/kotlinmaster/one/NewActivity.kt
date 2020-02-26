package org.kotlinmaster.one

import android.app.Activity
import android.os.Bundle

class NewActivity : MainActivity() {
    fun action(){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //
        var activity: Activity = NewActivity()
        //activity无法调用 NewActivity 的 action 方法的

        //使用 is 关键字进行「类型判断」，并且因为编译器能够进行类型推断，可以帮助我们省略强转的写法
        if (activity is NewActivity){
            activity.action()
        }

        //不进行类型判断，直接进行强转调用
        (activity as NewActivity).action()

        //'(activity as? NewActivity)' 之后是一个可空类型的对象，所以，需要使用 '?.' 来调用
        //如果强转成功就执行之后的调用，如果强转不成功就不执行。
        (activity as? NewActivity)?.action()

    }

    //只能修改父类方法的遗传性，即是否可
    final override fun test(){
    }
}