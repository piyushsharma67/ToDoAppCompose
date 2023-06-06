package com.example.todoappcompose.ui.screens.addToDo

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoappcompose.db.table.ToDoActivityTable
import com.example.todoappcompose.repository.activitiesRepository.ActivitiesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AddToDoScreenState(
    var name:String
)
@HiltViewModel
class AddToDoViewModel @Inject constructor(private val repository: ActivitiesRepository):ViewModel() {

    private var _addToDoScreenState = MutableStateFlow(AddToDoScreenState(""))
    val addToDoScreenState= _addToDoScreenState.asStateFlow()

    fun onClickSubmit(){
        viewModelScope.launch {
            repository.addActivity(ToDoActivityTable(activityName = _addToDoScreenState.value.name, id = null))
        }
    }

    fun onChangeActivityname(value:String){
        _addToDoScreenState.value=_addToDoScreenState.value.copy(name=value)
        println("sdsdasd ${_addToDoScreenState.value.name}")
    }
}