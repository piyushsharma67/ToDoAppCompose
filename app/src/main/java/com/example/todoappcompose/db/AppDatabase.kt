package com.example.todoappcompose.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoappcompose.db.dao.activityDao.ActivityDao
import com.example.todoappcompose.db.table.ToDoActivityTable

@Database(entities = [ToDoActivityTable::class], version = 1)
abstract class AppDatabase :RoomDatabase() {
    abstract fun activitiesDao() : ActivityDao
}