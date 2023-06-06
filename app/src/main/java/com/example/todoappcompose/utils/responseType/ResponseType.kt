package com.example.todoappcompose.utils.responseType

sealed class ResponseType<T>(val data:T?=null,val error:String?=null) {
    class Loading<T> : ResponseType<T>()
    class Fulfilled<T>(data:T) :ResponseType<T>(data=data)
    class Error<T>(errorMessage:String) :ResponseType<T>(error = errorMessage)
}