package org.kotlinmaster.five

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import org.kotlinmaster.R
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class FiveActivity: AppCompatActivity(), CoroutineScope {
    lateinit var job: Job
    lateinit var imageView: ImageView

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        job = Job()
        imageView = findViewById(R.id.iamgeView)

        //开启协程并打印当前线程名
        val coroutineScope = CoroutineScope(coroutineContext)
        coroutineScope.launch {
            println("--当前线程名：${Thread.currentThread().name}" )
        }


        launch(Dispatchers.IO) {
            println("--当前线程名：${Thread.currentThread().name}" )
        }

        val imageUrl = "https://himg2.huanqiucdn.cn/attachment2010/2020/0321/20200321071950687.jpg"
        loadData(imageUrl)

    }

    override fun onDestroy() {
        super.onDestroy()

        job.cancel()
    }

    //开启协程下载一张网络图片并显示在页面上
    fun loadData(imageUrl: String) = launch(Dispatchers.IO) {
        val url = URL(imageUrl)
        val conn = url.openConnection()
        conn.doInput = true
        conn.connect()

        val inputStream = conn.getInputStream()
        val bitmap = BitmapFactory.decodeStream(inputStream)
        inputStream.close()

        launch(Dispatchers.Main) {
            imageView.setImageBitmap(bitmap)
        }
    }


}