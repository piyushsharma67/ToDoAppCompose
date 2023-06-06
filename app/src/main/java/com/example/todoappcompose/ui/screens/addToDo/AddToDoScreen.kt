package com.example.todoappcompose.ui.screens.addToDo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoappcompose.ui.screens.addToDo.components.MyTopBar
import com.example.todoappcompose.ui.screens.addToDo.components.NavigationIconType
import com.example.todoappcompose.ui.screens.todoList.ToDoListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddToDoScreen(
    navigateBack:() -> Unit,
    modifier: Modifier=Modifier,
    toDoListViewModel: AddToDoViewModel = hiltViewModel()
){
    val uiState by toDoListViewModel.addToDoScreenState.collectAsState()
    Scaffold(
        topBar = {
           MyTopBar(
               title = "Add ToDo",
               navigationIcon = NavigationIconType.Back,
               onClickNavigationIcon=navigateBack,
               actions = {
                   Text(
                       text = "Submit",
                       color = MaterialTheme.colorScheme.onSecondary,
                       modifier=Modifier.padding(6.dp).clickable {
                           toDoListViewModel.onClickSubmit()
                       }
                   )
               }
           )
        }
    ) { it ->
        Box(
            modifier = modifier
                .padding(it)
                .fillMaxSize(1f)
            ,
            contentAlignment = Alignment.Center
        ){
            OutlinedTextField(
                value = uiState.name,
                onValueChange = { value ->
                    toDoListViewModel.onChangeActivityname(value)
                },
                modifier=Modifier.width(200.dp)
            )
        }
    }
}