package com.example.todo0107.Todo.TodoData

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoTable::class], version = 1, exportSchema = false)
abstract class TodoDatabase:RoomDatabase() {

    abstract fun getTodoDao(): TodoDao

    companion object{
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        private fun buildDatabase(context: Context): TodoDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java,
                "Todo"
            ).fallbackToDestructiveMigration().build()

        fun getInstance(context: Application): TodoDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it}
            }
    }

}