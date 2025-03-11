package com.example.todo2.model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

interface TodoApi {
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private var instance: TodoApi? = null

        fun getInstance(): TodoApi {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(TodoApi::class.java)
            }
            return instance!!
        }
    }
}