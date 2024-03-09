package br.com.todolist.dao;

import br.com.todolist.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class DBTodoList {
    private final List<Tarefa> listaDeTarefas = new ArrayList<>();

    public List<Tarefa> getListaDeTarefas() {
        return listaDeTarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        listaDeTarefas.add(tarefa);
    }

    public boolean removerTarefa(String nomeTarefa) {
        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getNome().equalsIgnoreCase(nomeTarefa)) {
                listaDeTarefas.remove(tarefa);
                return true;
            }
        }
        return false;
    }
}
