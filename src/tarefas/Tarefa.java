package tarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarefa {
    // Atributos
    private String nome;
    private String descricao;
    private String dataDeTermino;
    private int prioridade;
    private String categoria;
    private String status;

    private static List<Tarefa> listaDeTarefas = new ArrayList<>();

    // Construtor
    public Tarefa(String nome, String descricao, String dataDeTermino, int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = dataDeTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public static List<Tarefa> getListaDeTarefas() {
        return listaDeTarefas;
    }

    // Métodos
    public static void criarTarefa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da tarefa: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição da tarefa: ");
        String descricao = scanner.nextLine();

        System.out.print("Data de término da tarefa: ");
        String dataDeTermino = scanner.nextLine();

        System.out.print("Prioridade da tarefa (1-5): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente

        System.out.print("Categoria da tarefa: ");
        String categoria = scanner.nextLine();

        System.out.print("Status da tarefa: ");
        String status = scanner.nextLine();

        // Criar uma nova instância de Tarefa
        Tarefa novaTarefa = new Tarefa(nome, descricao, dataDeTermino, prioridade, categoria, status);

        // Adicionar a nova tarefa à lista de tarefas
        listaDeTarefas.add(novaTarefa);

        System.out.println("Tarefa criada com sucesso!");
    }

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(String dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

