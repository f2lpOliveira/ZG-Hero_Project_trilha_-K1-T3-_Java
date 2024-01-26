package tarefa;

public class CriarTarefa {

    // Atributos
    private String nome;
    private String descricao;
    private String dataDeTermino;
    private int nivelDePrioridade;
    private String categoria;
    private String status;

    // Construtor
    public CriarTarefa(String nome, String descricao, String dataDeTermino, int nivelDePrioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = dataDeTermino;
        this.nivelDePrioridade = nivelDePrioridade;
        this.categoria = categoria;
        this.status = status;
    }

    // Metodos
    public void tarefaCadastrada(){
        System.out.println("Tarefa: " + getNome());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Data do Término: " + getDataDeTermino());
        System.out.println("Prioridade: " + getNivelDePrioridade());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Status: " + getStatus());
    }
    private String getNome() {
        return nome;
    }

    private String getDescricao() {
        return descricao;
    }

    private String getDataDeTermino() {
        return dataDeTermino;
    }

    private int getNivelDePrioridade() {
        return nivelDePrioridade;
    }

    private String getCategoria() {
        return categoria;
    }

    private String getStatus() {
        return status;
    }

}


