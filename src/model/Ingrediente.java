package model;

public class Ingrediente {
    private Integer codIgrediente;
    private String nome;
    private String descricao;

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

    public Ingrediente(Integer codIgrediente, String nome, String descricao) {
        this.codIgrediente = codIgrediente;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Ingrediente() {
    }
}
