package app.todolist.controller;

import app.todolist.DAO.DBTodoList;
import app.todolist.model.Tarefa;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Operacoes {
    private final Scanner scanner;
    private final Timer timer;
    private final DBTodoList dbTodoList;

    public Operacoes(Scanner scanner, Timer timer, DBTodoList dbTodoList) {
        this.scanner = scanner;
        this.timer = timer;
        this.dbTodoList = dbTodoList;
    }

    public void listarTodas() {
        System.out.println("Escolha uma opção para listar tarefas:");
        System.out.println("1. Por Categoria");
        System.out.println("2. Por Prioridade");
        System.out.println("3. Por Status");
        System.out.println("4. Todas");
        System.out.print("Digite o número da opção desejada (1-4): ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                listarPorCategoria();
                break;
            case 2:
                listarPorPrioridade();
                break;
            case 3:
                listarPorStatus();
                break;
            case 4:
                listarTodasSemOpcao();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void listarTodasSemOpcao() {
        if (dbTodoList.getListaDeTarefas().isEmpty()) {
            System.out.println("A lista de tarefas está vazia.");
        } else {
            for (Tarefa tarefa : dbTodoList.getListaDeTarefas()) {
                tarefa.toString(tarefa);
            }
        }
    }

    public void excluirTarefa() {
        listarTodas();
        System.out.print("Digite o nome da tarefa que deseja excluir: ");
        String nomeTarefaExcluir = scanner.nextLine();
        if (dbTodoList.removerTarefa(nomeTarefaExcluir)) {
            System.out.println("Tarefa excluída com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada. Verifique o nome e tente novamente.");
        }
    }

    public void criarTarefa() {
        System.out.print("Nome da tarefa: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição da tarefa: ");
        String descricao = scanner.nextLine();

        System.out.print("Data de término da tarefa (DD/MM/YYYY): ");
        String dataDeTermino = scanner.nextLine();

        System.out.print("Hora de término da tarefa (0-23): ");
        int horaTermino = scanner.nextInt();

        System.out.print("Minuto de término da tarefa (0-59): ");
        int minutoTermino = scanner.nextInt();

        System.out.print("Prioridade da tarefa (1-5): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Categoria da tarefa (Casa ou Trabalho): ");
        String categoria = scanner.nextLine();

        System.out.print("Status da tarefa (ToDo, Doing ou Done): ");
        String status = scanner.nextLine();

        LocalDateTime dataHoraTermino = LocalDateTime.of(
                LocalDate.parse(dataDeTermino, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.of(horaTermino, minutoTermino)
        );

        Tarefa novaTarefa = new Tarefa(nome, descricao, dataHoraTermino, prioridade, categoria, status);
        dbTodoList.adicionarTarefa(novaTarefa);
        agendarAlarme(novaTarefa);
        System.out.println("Tarefa criada com sucesso!");
    }


    public void listarPorCategoria() {
        System.out.print("Digite a categoria desejada (Casa ou Trabalho): ");
        String categoria = scanner.nextLine();
        boolean encontrou = false;

        for (Tarefa tarefa : dbTodoList.getListaDeTarefas()) {
            if (tarefa.getCategoria().equalsIgnoreCase(categoria)) {
                tarefa.toString(tarefa);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não há nenhuma tarefa com a categoria " + categoria);
        }
    }

    public void listarPorPrioridade() {
        System.out.print("Digite a prioridade desejada (1-5): ");
        int prioridade = scanner.nextInt();
        boolean encontrou = false;

        for (Tarefa tarefa : dbTodoList.getListaDeTarefas()) {
            if (tarefa.getPrioridade() == prioridade) {
                tarefa.toString(tarefa);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não há nenhuma tarefa de prioridade " + prioridade);
        }
    }

    public void listarPorStatus() {
        System.out.print("Digite o status desejado (ToDo, Doing ou Done): ");
        String status = scanner.nextLine();
        boolean encontrou = false;

        for (Tarefa tarefa : dbTodoList.getListaDeTarefas()) {
            if (tarefa.getStatus().equalsIgnoreCase(status)) {
                tarefa.toString(tarefa);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não há nenhuma tarefa com o status " + status);
        }
    }

    private void agendarAlarme(Tarefa tarefa) {
        if (estaProximaDoTermino(tarefa)) {
            LocalDateTime dataHoraTermino = tarefa.getDataHoraTermino().minusHours(2);
            long delay = Duration.between(LocalDateTime.now(), dataHoraTermino).toMillis();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Alarme! A tarefa '" + tarefa.getNome() + "' está próxima do término.");
                }
            }, delay);
        }
    }

    private boolean estaProximaDoTermino(Tarefa tarefa) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        LocalDateTime dataHoraTermino = tarefa.getDataHoraTermino();
        return dataHoraAtual.isBefore(dataHoraTermino);
    }
}
