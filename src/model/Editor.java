package model;

import java.util.Date;

public class Editor extends Empregado{
    private Integer codEmpregado;

    public Editor() {
    }

    public Editor(Integer codigo, String nome, Date data_contrato, String rg, Integer cod_empregado) {
        super(codigo, nome, data_contrato, rg);
        this.codEmpregado = cod_empregado;
    }

    public Integer getCodEmpregado() {
        return codEmpregado;
    }

    public void setCodEmpregado(Integer codEmpregado) {
        this.codEmpregado = codEmpregado;
    }
}
