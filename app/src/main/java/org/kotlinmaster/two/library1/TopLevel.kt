package org.kotlinmaster.two.library1

//这样写的属性和函数，不属于任何 class，而是直接属于 package，它和静态变量、静态函数一样是全局的，
// 但用起来更方便：你在其它地方用的时候，就连类名都不用写：
fun method(){
    println("org.kotlinmaster.two.library1")
}