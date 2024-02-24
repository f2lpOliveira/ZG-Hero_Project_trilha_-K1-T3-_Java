package app.todolist.DAO;

import app.todolist.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class DBTodoList {
    private final List<Tarefa> listaDeTarefas = new ArrayList<>();

    public List<Tarefa> getListaDeTarefas() {
        return listaDeTarefas;
    }
}
