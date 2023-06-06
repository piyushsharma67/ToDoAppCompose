package com.example.todoappcompose.dependencyInjection.database.module

import android.content.Context
import androidx.room.Room
import com.example.todoappcompose.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDb(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(context,AppDatabase::class.java,"AppDatabase").build()
    }
}