package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentListBinding
import com.example.todolist.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val listTarefa = listOf(
            Tarefa(
                nome = "Estudar Spring Boot",
                descricao = "Mostrar que tem entendimento back end para Atados",
                responsavel = "Weslly",
                data = "06-08-2022",
                status = false,
                categoria = "Estudo e Conhecimento"

            ),
            Tarefa(
                nome = "Estudar Spring Boot",
                descricao = "Mostrar que tem entendimento back end para Atados",
                responsavel = "Weslly",
                data = "06-08-2022",
                status = false,
                categoria = "Estudo e Conhecimento"

            ),
            Tarefa(
                nome = "Estudar Spring Boot",
                descricao = "Mostrar que tem entendimento back end para Atados",
                responsavel = "Weslly",
                data = "06-08-2022",
                status = false,
                categoria = "Estudo e Conhecimento"

            )
        )

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }
}