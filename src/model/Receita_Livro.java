package model;

public class Receita_Livro {
    private Integer codReceita;
    private String livro;

    public Receita_Livro(Integer codReceita, String livro) {
        this.codReceita = codReceita;
        this.livro = livro;
    }

    public Receita_Livro() {
    }

    public Integer getCodReceita() {
        return codReceita;
    }

    public void setCodReceita(Integer codReceita) {
        this.codReceita = codReceita;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }
}
