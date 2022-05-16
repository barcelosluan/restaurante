package model;

import java.util.Date;

public class Empregado {
    private Integer codigo;
    private String nome;
    private Date dataCntrato;
    private String rg;

    public Empregado() {
    }

    public Empregado(Integer codigo, String nome, Date data_contrato, String rg) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataCntrato = data_contrato;
        this.rg = rg;
    }

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

    public Date getDataCntrato() {
        return dataCntrato;
    }

    public void setDataCntrato(Date dataCntrato) {
        this.dataCntrato = dataCntrato;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}
