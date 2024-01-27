package tarefas;

import java.util.ArrayList;
import java.util.Iterator;
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

    // Métodos da regra de negócio

    // Método para criar uma tarefa
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

    // Método para excluir uma tarefa com base no nome
    public static void excluirTarefa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da tarefa que deseja excluir: ");
        String nomeTarefaExcluir = scanner.nextLine();

        Iterator<Tarefa> iterator = listaDeTarefas.iterator();

        boolean encontrou = false;

        // Percorre a lista de tarefas
        while (iterator.hasNext()) {
            Tarefa novaTarefa = iterator.next();

            // Verifica se o nome da tarefa coincide com o fornecido pelo usuário
            if (novaTarefa.getNome().equalsIgnoreCase(nomeTarefaExcluir)) {
                iterator.remove();
                encontrou = true;
                System.out.println("Tarefa excluída com sucesso!");
                break; // Se encontrou a tarefa, podemos sair do loop
            }
        }

        // Se não encontrou a tarefa
        if (!encontrou) {
            System.out.println("Tarefa não encontrada. Verifique o nome e tente novamente.");
        }
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

