package com.example.todoappcompose.repository.activitiesRepository

import androidx.lifecycle.MutableLiveData
import com.example.todoappcompose.db.AppDatabase
import com.example.todoappcompose.db.table.ToDoActivityTable
import com.example.todoappcompose.models.activity.ToDoActivity
import com.example.todoappcompose.utils.responseType.ResponseType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ActivitiesRepository @Inject constructor(private val database: AppDatabase) {

    suspend fun getActivities(): Flow<ResponseType<List<ToDoActivityTable>>> {
        return flow {
            try{
                emit(ResponseType.Loading())
                val activities=database.activitiesDao().FetchToDoActivities()
                emit(ResponseType.Fulfilled(activities))
            }catch (error:IOException){
                emit(ResponseType.Error(error.message!!))
            }
        }
    }


    suspend fun addActivity(activityTable: ToDoActivityTable){
        database.activitiesDao().InsertToDoActivity(activityTable)
    }
}