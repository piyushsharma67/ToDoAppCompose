package com.example.todoappcompose.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoActivities")
data class ToDoActivityTable (
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    val activityName:String
)

