package br.com.todolist;

import br.com.todolist.dao.DBTodoList;
import br.com.todolist.controller.Operacoes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
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
        // Given
        int contadorInicialTarefa = dbTodoList.getListaDeTarefas().size();

        // When
        operacoes.criarTarefa();

        // Then
        int tarefaAposCriacao = dbTodoList.getListaDeTarefas().size();
        assertEquals(contadorInicialTarefa + 1, tarefaAposCriacao, "Deve haver uma tarefa adicional na lista após a criação.");
    }
}