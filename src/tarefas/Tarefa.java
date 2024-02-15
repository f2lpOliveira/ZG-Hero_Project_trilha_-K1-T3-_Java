package tarefas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Tarefa {
    private final String nome;
    private final String descricao;
    private final LocalDateTime dataHoraTermino;
    private final int prioridade;
    private final String categoria;
    private final String status;
    private final static List<Tarefa> listaDeTarefas = new ArrayList<>();
    private final Timer timer;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Tarefa(String nome, String descricao, String dataDeTermino, int horaTermino, int minutoTermino, int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        LocalDate data = LocalDate.parse(dataDeTermino, formatter);
        this.dataHoraTermino = LocalDateTime.of(data, LocalTime.of(horaTermino, minutoTermino));
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
        this.timer = new Timer();
        listaDeTarefas.add(this);
        agendarAlarme();
    }

    public boolean estaProximaDoTermino() {
        LocalDateTime dataHoraNotificacao = LocalDateTime.now().plusMinutes(1);
        return dataHoraNotificacao.isAfter(LocalDateTime.now()) && dataHoraNotificacao.isBefore(dataHoraTermino);
    }

    private void agendarAlarme() {
        if (estaProximaDoTermino()) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Alarme! A tarefa '" + nome + "' está próxima do término.");
                }
            }, java.util.Date.from(dataHoraTermino.atZone(java.time.ZoneId.systemDefault()).toInstant()));
        }
    }

    public static void criarTarefa() {
        Scanner scanner = new Scanner(System.in);
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

        Tarefa novaTarefa = new Tarefa(nome, descricao, dataDeTermino, horaTermino, minutoTermino, prioridade, categoria, status);
        System.out.println("Tarefa criada com sucesso!");
    }

    public static void listarTarefas() {
        Scanner scanner = new Scanner(System.in);

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
                listarTodas();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public static void listarTodas() {
        listaDeTarefas.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());

        for (Tarefa tarefa : listaDeTarefas) {
            exibirDetalhesTarefa(tarefa);
        }
    }
    private static void listarPorCategoria() {
        System.out.print("Digite a categoria desejada (Casa ou Trabalho): ");
        String categoria = new Scanner(System.in).nextLine();

        listaDeTarefas.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());

        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getCategoria().equalsIgnoreCase(categoria)) {
                exibirDetalhesTarefa(tarefa);
            } else {
                System.out.println("Não há nenhuma tarefa com a categoria " + categoria);
                break;
            }
        }
    }
    private static void listarPorPrioridade() {
        System.out.print("Digite a prioridade desejada (1-5): ");
        int prioridade = new Scanner(System.in).nextInt();

        listaDeTarefas.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());

        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getPrioridade() == prioridade) {
                exibirDetalhesTarefa(tarefa);
            } else {
                System.out.println("Não há nenhuma tarefa de prioridade " + prioridade);
                break;
            }
        }
    }
    private static void listarPorStatus() {
        System.out.print("Digite o status desejado (ToDo, Doing ou Done): ");
        String status = new Scanner(System.in).nextLine();

        listaDeTarefas.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());

        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getStatus().equalsIgnoreCase(status)) {
                exibirDetalhesTarefa(tarefa);
            } else {
                System.out.println("Não há nenhuma tarefa com o status " + status);
                break;
            }
        }
    }

    public static void excluirTarefa() {
        Scanner scanner = new Scanner(System.in);

        listarTodas();
        System.out.print("Digite o nome da tarefa que deseja excluir: ");
        String nomeTarefaExcluir = scanner.nextLine();

        Iterator<Tarefa> iterator = listaDeTarefas.iterator();

        boolean encontrou = false;

        while (iterator.hasNext()) {
            Tarefa novaTarefa = iterator.next();

            if (novaTarefa.getNome().equalsIgnoreCase(nomeTarefaExcluir)) {
                iterator.remove();
                encontrou = true;
                System.out.println("Tarefa excluída com sucesso!");
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Tarefa não encontrada. Verifique o nome e tente novamente.");
        }
    }

    private static void exibirDetalhesTarefa(Tarefa tarefa) {
        System.out.println("Nome: " + tarefa.getNome());
        System.out.println("Descrição: " + tarefa.getDescricao());
        System.out.println("Data de Término: " + tarefa.getDataDeTermino());
        System.out.println("Hora de Término: " + tarefa.getDataHoraTermino().getHour());
        System.out.println("Minuto de Término: " + tarefa.getDataHoraTermino().getMinute());
        System.out.println("Prioridade: " + tarefa.getPrioridade());
        System.out.println("Categoria: " + tarefa.getCategoria());
        System.out.println("Status: " + tarefa.getStatus());
        System.out.println("---------------");
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataDeTermino() {
        return formatter.format(dataHoraTermino);
    }

    public LocalDateTime getDataHoraTermino() {
        return dataHoraTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }
}

