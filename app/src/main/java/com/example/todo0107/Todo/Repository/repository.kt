package com.example.todo0107.Todo.Repository

import androidx.lifecycle.LiveData
import com.example.todo0107.Todo.TodoData.TodoDao
import com.example.todo0107.Todo.TodoData.TodoTable

class repository(private val todoDao:TodoDao) {

    val getReadAll:LiveData<List<TodoTable>> = todoDao.readAll()

    suspend fun addData(inputData: TodoTable){
        todoDao.addData(inputData)
    }

    suspend fun updateData(inputData: TodoTable){
        todoDao.updateData(inputData)
    }

    suspend fun deleteData(inputData: TodoTable){
        todoDao.daleteData(inputData)
    }


}