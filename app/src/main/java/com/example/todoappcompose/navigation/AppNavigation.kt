package com.example.todoappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoappcompose.ui.screens.addToDo.AddToDoScreen
import com.example.todoappcompose.ui.screens.todoList.ToDoListScreen
import com.example.todoappcompose.utils.enums.AppDestinationsUrls
import com.example.todoappcompose.utils.enums.AppRootDestinationsUrl

@Composable
fun AppNavGraph(
    navController: NavHostController= rememberNavController()
){
    NavHost(
        navController = navController,
        route = AppRootDestinationsUrl.Main.route,
        startDestination = AppDestinationsUrls.ToDoListScreenUrl.route
    ){
        composable(AppDestinationsUrls.ToDoListScreenUrl.route){
            ToDoListScreen(
                navigateToAddToDoScreen={navController.navigate(AppDestinationsUrls.AddToDoScreenUrl.route)}
            )
        }
        composable(AppDestinationsUrls.AddToDoScreenUrl.route){
            AddToDoScreen(
                navigateBack={navController.popBackStack()}
            )
        }
    }
}