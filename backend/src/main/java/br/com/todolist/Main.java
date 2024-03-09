package br.com.todolist;

import br.com.todolist.dao.DBTodoList;
import br.com.todolist.controller.MenuIterativo;
import br.com.todolist.controller.Operacoes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes(new Scanner(System.in), new Timer(), new DBTodoList());
        MenuIterativo menu = new MenuIterativo(operacoes);
        menu.apresentacao();
    }
}
