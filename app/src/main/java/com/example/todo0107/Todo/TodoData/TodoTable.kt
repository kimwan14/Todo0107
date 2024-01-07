package com.example.todo0107.Todo.TodoData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todo")
data class TodoTable (
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,
    val title:String,
    val icon:String
)