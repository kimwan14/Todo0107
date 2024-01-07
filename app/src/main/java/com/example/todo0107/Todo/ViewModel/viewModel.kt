package com.example.todo0107.Todo.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todo0107.Todo.Repository.repository
import com.example.todo0107.Todo.TodoData.TodoDatabase
import com.example.todo0107.Todo.TodoData.TodoTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewModel(application: Application): AndroidViewModel(application) {

    private val todoRepository: repository
    val getReadAll:LiveData<List<TodoTable>>

    init {
        val db = TodoDatabase.getInstance(application).getTodoDao()
        todoRepository = repository(db)
        getReadAll = todoRepository.getReadAll
    }

    suspend fun addTodo(inputData:TodoTable){
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.addData(inputData)
        }
    }

    suspend fun updateTodo(inputData:TodoTable){
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.updateData(inputData)
        }
    }

    suspend fun deleteTodo(inputData:TodoTable){
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.deleteData(inputData)
        }
    }


}