package com.example.todo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.todo2.viewmodel.TodoViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TodoList(viewModel: TodoViewModel) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(viewModel.todos) { todo ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = todo.title, style = MaterialTheme.typography.titleLarge)
                    Text(
                        text = if (todo.completed) "Completed" else "Not Completed",
                        color = if (todo.completed) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = TodoViewModel()
        setContent {
            MaterialTheme {
                TodoList(viewModel)
            }
        }
    }
}
