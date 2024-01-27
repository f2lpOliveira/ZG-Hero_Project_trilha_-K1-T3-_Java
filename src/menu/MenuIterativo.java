package menu;

import tarefas.Tarefa;

import java.util.Scanner;

public class MenuIterativo {
    // Método para apresentar o menu
    public static void apresentacao() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Excluir tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção (1-4): ");

            // Lê a escolha do usuário
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            // Executa a opção escolhida
            switch (escolha) {
                case 1:
                    Tarefa.criarTarefa();
                    break;
                case 2:
                    Tarefa.listarTarefas();
                    break;
                case 3:
                    Tarefa.excluirTarefa();
                    break;
                case 4:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 4);
    }

}

