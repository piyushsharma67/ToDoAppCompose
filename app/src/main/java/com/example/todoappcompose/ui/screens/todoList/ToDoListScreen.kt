package com.example.todoappcompose.ui.screens.todoList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import com.example.todoappcompose.components.spiningLoader.SpiningLoader
import com.example.todoappcompose.ui.screens.addToDo.components.MyTopBar
import com.example.todoappcompose.ui.screens.addToDo.components.NavigationIconType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListScreen(
    navigateToAddToDoScreen:() -> Unit,
    modifier: Modifier=Modifier,
    toDoListViewModel: ToDoListViewModel = hiltViewModel(),
    lifeCycleOwner: LifecycleOwner= LocalLifecycleOwner.current
){
    val listUiState by toDoListViewModel.listState.collectAsState()
    val loading by toDoListViewModel.loadingState.collectAsState()

    DisposableEffect(lifeCycleOwner){
        lifeCycleOwner.lifecycle.addObserver(toDoListViewModel)
        onDispose {
            lifeCycleOwner.lifecycle.removeObserver(toDoListViewModel)
        }
    }

    Scaffold(
        topBar = {
            MyTopBar(
                title = "ToDo List",
                navigationIcon = NavigationIconType.Menu,
                onClickNavigationIcon = navigateToAddToDoScreen,
                actions = {
                    IconButton(onClick = {navigateToAddToDoScreen() }) {
                        Icon(painter = painterResource(id =com.example.todoappcompose.R.drawable.add ), contentDescription = "add Button" , tint = MaterialTheme.colorScheme.onSecondary)
                    }
                }
            )
        }
    ){
        Box(modifier = modifier.padding(it)){
            if(loading){
                SpiningLoader()
            }else{

                Box(modifier=Modifier.fillMaxSize()){
                    Column(modifier=Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
                        listUiState.forEach {
                            Text(it.activityName)
                        }
                    }
                }
            }
        }
    }
}


