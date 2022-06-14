package model;

import java.util.Date;

public class Receita {
    private Integer codigo;
    private String nome;
    private Date dataCriacao;
    private Integer codCozinheiro;
    private String nomeCozinheiro;
    private Integer codCategoria;
    private String nomeCategoria;

    public String getNomeCozinheiro() {return nomeCozinheiro;}

    public void setNomeCozinheiro(String nomeCozinheiro) {this.nomeCozinheiro = nomeCozinheiro;}

    public String getNomeCategoria() {return nomeCategoria;}

    public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getCodCozinheiro() {
        return codCozinheiro;
    }

    public void setCodCozinheiro(Integer codCozinheiro) {
        this.codCozinheiro = codCozinheiro;
    }

    public Integer getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Integer codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Receita(Integer codigo, String nome, Date dataCriacao, Integer codCozinheiro, Integer codCategoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.codCozinheiro = codCozinheiro;
        this.codCategoria = codCategoria;
    }
    public Receita(Integer codigo, String nome, Integer codCozinheiro, Integer codCategoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.codCozinheiro = codCozinheiro;
        this.codCategoria = codCategoria;
    }
    public Receita(Integer codigo, String nome, Date dataCriacao, String nomeCozinheiro, String nomeCategoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.nomeCozinheiro = nomeCozinheiro;
        this.nomeCategoria = nomeCategoria;
    }
    public Receita(Integer codigo, String nome, String nomeCozinheiro) {
        this.codigo = codigo;
        this.nome = nome;
        this.nomeCozinheiro = nomeCozinheiro;
    }
    public Receita() {
    }
}
