package model;

import java.util.Date;

public class Degustador_Receita {
    private Integer codDegustador;
    private Integer codReceita;
    private Date dataDegustacao;
    private Double nota;

    public Degustador_Receita() {
    }

    public Degustador_Receita(Integer codDegustador, Integer codReceita, Date dataDegustacao, Double nota) {
        this.codDegustador = codDegustador;
        this.codReceita = codReceita;
        this.dataDegustacao = dataDegustacao;
        this.nota = nota;
    }

    public Integer getCodDegustador() {
        return codDegustador;
    }

    public void setCodDegustador(Integer codDegustador) {
        this.codDegustador = codDegustador;
    }

    public Integer getCodReceita() {
        return codReceita;
    }

    public void setCodReceita(Integer codReceita) {
        this.codReceita = codReceita;
    }

    public Date getDataDegustacao() {
        return dataDegustacao;
    }

    public void setDataDegustacao(Date dataDegustacao) {
        this.dataDegustacao = dataDegustacao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
