package tarefa;

public class CriarTarefa {
    private String nome;
    private String descricao;
    private String dataDeTermino;
    private int prioridade;
    private String categoria;
    private String status;

    // Construtor
    public CriarTarefa(String nome, String descricao, String dataDeTermino, int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = dataDeTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    // Métodos Getter
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataDeTermino() {
        return dataDeTermino;
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

    // Métodos Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataDeTermino(String dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

