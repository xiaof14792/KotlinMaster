package org.kotlinmaster.four

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //泛型练习题
        val textViewList: Array<TextView> = arrayOf(TextView(this))
        fill(textViewList, Button(this))

        val buttonList: Array<Button> = arrayOf(Button(this))
        copy(textViewList, buttonList)
    }

    fun fill(array: Array<in Button>, button: Button) {
        array.set(0, button)
    }

    fun copy(array1: Array<in TextView>, array2: Array<out Button>){
        for (i in array2.indices){
            array1[i] = array2[i]
        }
    }
}