package com.example.coroutinesdemo

data class WrapperResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)