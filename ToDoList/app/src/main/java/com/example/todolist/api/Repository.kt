package com.example.todolist.api

import com.example.todolist.model.Categoria
import com.example.todolist.model.Tarefa
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa> {
        return RetrofitInstance.api.addTarefa(tarefa)
    }

}