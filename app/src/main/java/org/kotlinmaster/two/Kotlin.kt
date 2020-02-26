package org.kotlinmaster.two

/**
 * 练习一
 */
class Kotlin private constructor(){

    companion object{
        fun newInstance(): Kotlin{
            return Kotlin()
        }
    }

    class Inner{
        companion object {
            fun newInstance(): Kotlin{
                return Kotlin()
            }
        }

        fun newInstance(): Kotlin{
            return Kotlin()
        }
    }
}