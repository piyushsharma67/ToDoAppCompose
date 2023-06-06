package com.example.todoappcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.todoappcompose.navigation.AppNavGraph

@Composable
fun ToDoApp(){
    val navController=rememberNavController()
    AppNavGraph(navController)
}