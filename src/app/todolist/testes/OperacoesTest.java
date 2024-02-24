package app.todolist.testes;

import app.todolist.DAO.DBTodoList;
import app.todolist.controller.Operacoes;
import app.todolist.model.Tarefa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperacoesTest {

    private Operacoes operacoes;
    private DBTodoList dbTodoList;

    @BeforeEach
    public void setUp() {
        dbTodoList = new DBTodoList();

        ByteArrayInputStream in = new ByteArrayInputStream("Nome\nDescrição\n01/01/2023\n10\n30\n1\nCasa\nToDo\n".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        operacoes = new Operacoes(scanner, null, dbTodoList); // Timer não é usado no teste
    }

    @Test
    public void givenEmptyTodoList_whenCreateTask_thenTaskIsAddedToList() {
        List<Tarefa> initialTasks = dbTodoList.getListaDeTarefas();
        assertEquals(0, initialTasks.size(), "A lista de tarefas deve estar vazia no início.");

        operacoes.criarTarefa();

        List<Tarefa> tasksAfterCreation = dbTodoList.getListaDeTarefas();
        assertEquals(1, tasksAfterCreation.size(), "Deve haver uma tarefa na lista após a criação.");

        Tarefa tarefaCriada = tasksAfterCreation.get(0);
        assertEquals("Nome", tarefaCriada.getNome(), "O nome da tarefa deve ser 'Nome'.");
        assertEquals("Descrição", tarefaCriada.getDescricao(), "A descrição da tarefa deve ser 'Descrição'.");
        assertEquals(LocalDateTime.of(2023, 1, 1, 10, 30), tarefaCriada.getDataHoraTermino(), "A data de término da tarefa deve ser 01/01/2023 às 10:30.");
        assertEquals(1, tarefaCriada.getPrioridade(), "A prioridade da tarefa deve ser 1.");
        assertEquals("Casa", tarefaCriada.getCategoria(), "A categoria da tarefa deve ser 'Casa'.");
        assertEquals("ToDo", tarefaCriada.getStatus(), "O status da tarefa deve ser 'ToDo'.");
    }
}