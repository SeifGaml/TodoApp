package com.example.todoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.Dao.TasksDao
import com.example.todoapp.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = true)

abstract class MyDataBase:RoomDatabase() {

    abstract fun tasksDao():TasksDao

    companion object{
        private var instance:MyDataBase?= null

        fun getInstance(context: Context):MyDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, MyDataBase::class.java,"TasksDatabase")
                    .allowMainThreadQueries()// allow to create thread in main Queire  UI
                    .fallbackToDestructiveMigration() //
                    .build()

            }
            return instance!!

        }

    }



}