package com.example.todolist.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.MainViewModel
import com.example.todolist.databinding.CardLayoutBinding
import com.example.todolist.model.Tarefa

class TarefaAdapter(
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel,
    val context: Context
) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

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
        holder.binding.textCategoria.text = tarefa.categoria.descricao

        // Clicando em um item da lista
        holder.itemView.setOnClickListener {
            taskClickListener.onTaskClickListener(tarefa)
        }

        holder.binding.switchAtivo
            .setOnCheckedChangeListener { compoundButton, ativo ->
                tarefa.status = ativo
                mainViewModel.updateTarefa(tarefa)
            }

        holder.binding.buttonDeletar.setOnClickListener {
            showAlertDialog(tarefa.id)
        }
    }

    // Retorna a quantidade de vezes que precisa gerar os itens
    override fun getItemCount(): Int {
        return listTarefa.size
    }

    // Método para setar a lista
    fun setList(list: List<Tarefa>){
        // Trocando o conteúdo da lista vazia pela nova lista que vamos trazer externamente
        listTarefa = list.sortedByDescending { it.id }
        // Fazendo que a lista seja atualizada, atualizando os itens do RecyclerView
        notifyDataSetChanged()
    }

    private fun showAlertDialog(id: Long){
        AlertDialog.Builder(context)
            .setTitle("Excluir Tarefa")
            .setMessage("Deseja excluir a Tarefa?")
            .setPositiveButton("Sim"){
                _,_ -> mainViewModel.deleteTarefa(id)
            }
            .setNegativeButton("Não"){
                _,_ ->
            }.show()
    }
}