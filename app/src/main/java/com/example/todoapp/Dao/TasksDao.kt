package com.example.todoapp.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.model.Task

@Dao

interface TasksDao {

    @Insert
    fun insertTask(task:Task)


    @Update
    fun updateTask(task: Task)


    @Delete
    fun deleteTask(task:Task)

    @Query("select * from Tasks")
    fun getAllTasks():List<Task>

    @Query("select *from tasks where dateTime = :dateTime")
    fun getAllTaskBYDate(dateTime:Long):List<Task>
}