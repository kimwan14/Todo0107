package com.example.todo0107.Todo.TodoData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Insert
    suspend fun addData(inputData: TodoTable)

    @Update
    suspend fun updateData(inputData: TodoTable)

    @Delete
    suspend fun daleteData(inputData: TodoTable)

    @Query("select * from Todo order by id asc" )
    fun readAll():LiveData<List<TodoTable>>
}