package com.example.todolist.adapter

import com.example.todolist.model.Tarefa

interface TaskClickListener {

    fun onTaskClickListener(tarefa: Tarefa)
}