package com.example.todo2.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo2.model.Todo
import com.example.todo2.model.TodoApi
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    var todos = mutableStateListOf<Todo>()
        private set

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val api = TodoApi.getInstance()
                todos.clear()
                todos.addAll(api.getTodos())
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
            }
        }
    }
}
