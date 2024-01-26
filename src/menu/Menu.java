package menu;

import tarefa.CriarTarefa;
import tarefa.AtualizarTarefa;
import tarefa.ListarTarefas;
import tarefa.DeletarTarefa;

import java.util.Scanner;

public class Menu {
    private CriarTarefa criarTarefa;
    private AtualizarTarefa atualizarTarefa;
    private ListarTarefas listarTarefas;
    private DeletarTarefa deletarTarefa;

    public Menu() {
        criarTarefa = new CriarTarefa();
        atualizarTarefa = new AtualizarTarefa();
        listarTarefas = new ListarTarefas();
        deletarTarefa = new DeletarTarefa();
    }

    public void executarMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("===== Menu de Tarefas =====");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("4. Excluir Tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    criarTarefa.executarCriacao();
                    break;
                case 2:
                    listarTarefas.executarListagem();
                    break;
                case 3:
                    atualizarTarefa.executarAtualizacao();
                    break;
                case 4:
                    deletarTarefa.executarDelecao();
                    break;
                case 5:
                    System.out.println("Saindo do Gerenciador de Tarefas. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 5);

        scanner.close();
    }
}
