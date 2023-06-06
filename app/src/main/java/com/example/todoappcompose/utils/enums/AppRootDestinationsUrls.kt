package com.example.todoappcompose.utils.enums

enum class AppRootDestinationsUrl(val route:String){
    Main("https://www.ToDoApp.com")
}

enum class AppDestinationsUrls(val route:String) {
    ToDoListScreenUrl("${AppRootDestinationsUrl.Main}/ToDoListScreen"),
    AddToDoScreenUrl("${AppRootDestinationsUrl.Main}/AddToDoScreen")
}