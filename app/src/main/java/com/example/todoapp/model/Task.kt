package com.example.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("tasks")
data class Task(


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("Id") val id :Int? = null,
    @ColumnInfo var title :String? = null ,
    @ColumnInfo var description:String?=null,
    @ColumnInfo var dateTime :Long? = null ,
    @ColumnInfo var isDone:Boolean=false
)
// @index( ) ==> {key,value} is other file that inside key and value for some data  hash table binary search tree

