package model;

import java.util.Date;

public class Cozinheiro extends Empregado{
    private Integer codEmpregado;

    private String fantasia;

    private int qtd_receitas;


    public Cozinheiro() {
    }

    public Cozinheiro(Integer codigo, String nome, Date data_contrato, String rg, String fantasia) {
        super(codigo, nome, data_contrato, rg);
        this.codEmpregado=codigo;
        this.fantasia=fantasia;
    }

    public Cozinheiro(String fantasia, String nome, int qtd_receitas) {
        super(nome);
        this.fantasia=fantasia;
        this.qtd_receitas=qtd_receitas;
    }

    public Integer getCodEmpregado() {
        return codEmpregado;
    }

    public void setCodEmpregado(Integer codEmpregado) {
        this.codEmpregado = codEmpregado;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public int getQtd_receitas() {return qtd_receitas;}

    public void setQtd_receitas(int qtd_receitas) {this.qtd_receitas = qtd_receitas;}
}
