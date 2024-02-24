package app.todolist;

import app.todolist.DAO.DBTodoList;
import app.todolist.controller.MenuIterativo;
import app.todolist.controller.Operacoes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes(new Scanner(System.in), new Timer(), new DBTodoList());
        MenuIterativo menu = new MenuIterativo(operacoes);
        menu.apresentacao();
    }
}
