package com.example.coroutinesdemo

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {
    val retrofit = Retrofit.Builder()
        .baseUrl(ApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        //添加对Deffered的支持
        .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
        .build()
        .create(ApiService::class.java)


    fun login(name: String, password: String): Deferred<WrapperResponse<User>>{
        return retrofit.login(name, password)
    }

}