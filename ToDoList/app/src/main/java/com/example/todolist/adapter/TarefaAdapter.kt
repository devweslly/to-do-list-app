package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.CardLayoutBinding
import com.example.todolist.model.Tarefa

class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    private var listTarefa = emptyList<Tarefa>()

    class TarefaViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    // Criar Card que possui as info da Tarefa
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    // Criando Tarefa e joga os items nos componentes do card_layout
    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listTarefa[position]

        // Processando os itens que vai ter dentro de tarefa do card_layout
        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textResponsavel.text = tarefa.responsavel
        holder.binding.textData.text = tarefa.data
        holder.binding.switchAtivo.isChecked = tarefa.status
        holder.binding.textCategoria.text = tarefa.nome
    }

    // Retorna a quantidade de vezes que precisa gerar os itens
    override fun getItemCount(): Int {
        return listTarefa.size
    }

    // Método para setar a lista
    fun setList(list: List<Tarefa>){
        // Trocando o conteúdo da lista vazia pela nova lista que vamos trazer externamente
        listTarefa = list
        // Fazendo que a lista seja atualizada, atualizando os itens do RecyclerView
        notifyDataSetChanged()
    }
}