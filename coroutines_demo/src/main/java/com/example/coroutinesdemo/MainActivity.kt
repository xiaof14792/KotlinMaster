package com.example.coroutinesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var editUsername: EditText
    lateinit var editPassword: EditText
    lateinit var btn: Button
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        editUsername = findViewById(R.id.edit_username)
        editPassword = findViewById(R.id.edit_password)
        btn = findViewById(R.id.btn)
        text = findViewById(R.id.text_user)

        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        login_three()
    }

    fun login_one() {
        //通过launch函数开启一个协程
        GlobalScope.launch(Dispatchers.IO) {
            val repository = ApiRepository()

            var result: WeakResponse<User>? = null
            result = repository.login(
                editUsername.text.trimEnd().toString(),
                editPassword.text.trimEnd().toString()
            ).await()

            launch(Dispatchers.Main) {
                text.text = result.data.username
            }

        }
    }

    fun login_two() {
        //通过launch函数开启一个协程
        GlobalScope.launch(Dispatchers.Main) {
            val repository = ApiRepository()
            var result: WeakResponse<User>? = null

            //withContext。这个函数可以切换到指定的线程，并在闭包内的逻辑执行结束之后，自动把线程切回去继续执行
            withContext(Dispatchers.IO) {
                result = repository.login(
                    editUsername.text.trimEnd().toString(),
                    editPassword.text.trimEnd().toString()
                ).await()
            }


            text.text = result?.data?.username
        }
    }

    //既然不需要嵌套了，那就可以把io线程的操作，拿出来单独作为函数
    suspend fun login(name: String, password: String): WeakResponse<User> {
        return withContext(Dispatchers.IO){
            val repository = ApiRepository()
            repository.login(name, password).await()
        }
    }

    //用看起来同步的方式写出异步的代码
    fun login_three(){
        GlobalScope.launch(Dispatchers.Main) {
            val result = login(editUsername.text.trimEnd().toString(),
                editPassword.text.trimEnd().toString())
            text.text = result.data.username
        }
    }

}
