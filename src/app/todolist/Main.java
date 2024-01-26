package app.todolist;

import tarefa.CriarTarefa;

public class Main {
    public static void main(String[] args) {

        CriarTarefa tarefa1 = new CriarTarefa("Preparar o jantar.", "Cozinhar o arroz, fritar as batatas e o bife.", "26/01/2024", 5, "Casa", "A fazer");

        tarefa1.tarefaCadastrada();

    }
}