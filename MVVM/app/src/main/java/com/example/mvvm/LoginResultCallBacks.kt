package com.example.mvvm

interface LoginResultCallBacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}