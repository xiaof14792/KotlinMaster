package com.example.coroutinesdemo

data class WeakResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)