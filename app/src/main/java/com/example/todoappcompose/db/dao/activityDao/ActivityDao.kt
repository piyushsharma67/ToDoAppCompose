package com.example.todoappcompose.db.dao.activityDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todoappcompose.db.table.ToDoActivityTable
import com.example.todoappcompose.models.activity.ToDoActivity
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {

    @Insert
    suspend fun InsertToDoActivity(activity: ToDoActivityTable)

    @Query("SELECT * From todoActivities")
    suspend fun FetchToDoActivities(): List<ToDoActivityTable>
}