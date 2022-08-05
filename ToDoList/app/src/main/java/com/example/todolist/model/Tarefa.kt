package com.example.todolist.model

// Classe de modelo
data class Tarefa(
    var nome: String,
    var descricao: String,
    var responsavel: String,
    var data: String,
    var status: Boolean,
    var categoria: String
)