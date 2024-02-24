package app.todolist.model;

import java.time.LocalDateTime;

public class Tarefa {
    private final String nome;
    private final String descricao;
    private final LocalDateTime dataHoraTermino;
    private final int prioridade;
    private final String categoria;
    private final String status;

    public Tarefa(String nome, String descricao, LocalDateTime dataHoraTermino, int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataHoraTermino = dataHoraTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
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

    public void toString(Tarefa tarefa) {
        System.out.println("Nome: " + tarefa.getNome());
        System.out.println("Descrição: " + tarefa.getDescricao());
        System.out.println("Data de Término: " + tarefa.getDataHoraTermino().toLocalDate());
        System.out.println("Hora de Término: " + tarefa.getDataHoraTermino().getHour());
        System.out.println("Minuto de Término: " + tarefa.getDataHoraTermino().getMinute());
        System.out.println("Prioridade: " + tarefa.getPrioridade());
        System.out.println("Categoria: " + tarefa.getCategoria());
        System.out.println("Status: " + tarefa.getStatus());
        System.out.println("---------------");
    }
}