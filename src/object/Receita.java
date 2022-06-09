package object;

import java.util.Date;

public class Receita {
    private Integer codigo;
    private String nome;
    private Date dataCriacao;
    private Integer codCozinheiro;
    private Integer codCategoria;

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
    public Receita() {
    }
}
