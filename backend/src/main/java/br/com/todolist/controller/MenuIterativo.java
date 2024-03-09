package br.com.todolist.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuIterativo {

    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;
    Operacoes operacoes;

    public MenuIterativo(Operacoes operacoes) {
        this.operacoes = operacoes;
    }

    public void apresentacao() {
        int escolha;

        while (continuar){
            this.exibirOpcoes();

            try {
                escolha = this.entradaDados();

                switch (escolha) {
                    case 1:
                        operacoes.criarTarefa();
                        break;
                    case 2:
                        operacoes.listarTodas();
                        break;
                    case 3:
                        operacoes.excluirTarefa();
                        break;
                    case 4:
                        System.out.println("Saindo do programa. Até mais!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine();
            }
        }
    }

    public void exibirOpcoes() {
        System.out.println("----- Menu -----");
        System.out.println("1. Criar nova tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Excluir tarefas");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção (1-4): ");
    }

    public int entradaDados(){
        System.out.print("Digite um número inteiro: ");
        return scanner.nextInt();
    }
}

