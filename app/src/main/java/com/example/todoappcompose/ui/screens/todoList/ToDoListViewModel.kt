package com.example.todoappcompose.ui.screens.todoList

import androidx.compose.runtime.*
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoappcompose.db.table.ToDoActivityTable
import com.example.todoappcompose.repository.activitiesRepository.ActivitiesRepository
import com.example.todoappcompose.utils.responseType.ResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(private val repository: ActivitiesRepository):ViewModel(),DefaultLifecycleObserver {

    //     UI State variable initialization
    private var _listState = MutableStateFlow<List<ToDoActivityTable>>(listOf())
    val listState:StateFlow<List<ToDoActivityTable>> = _listState.asStateFlow()

    //     Loading State variable initialization
    private var _loadingState = MutableStateFlow<Boolean>(false)
    val loadingState:StateFlow<Boolean> = _loadingState.asStateFlow()

    private fun fetchToDoList(){
       viewModelScope.launch {
           repository.getActivities().collect {
               when (it) {
                   is ResponseType.Loading -> {
                        _loadingState.value=true
                   }
                   is ResponseType.Fulfilled ->{
                       _loadingState.value=false
                       _listState.value=it.data!!
                   }
                   is ResponseType.Error ->{
                        _loadingState.value=false
                   }
               }
           }
       }
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

        fetchToDoList()
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        println("on resume called")
        fetchToDoList()
    }
}