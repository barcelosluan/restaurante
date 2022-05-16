package model;

import java.util.Date;

public class Degustador extends Empregado{
    private Integer codEmpregado;

    public Degustador() {
    }

    public Degustador(Integer codigo, String nome, Date data_contrato, String rg) {
        super(codigo, nome, data_contrato, rg);
    }

    public Integer getCodEmpregado() {
        return codEmpregado;
    }

    public void setCodEmpregado(Integer codEmpregado) {
        this.codEmpregado = codEmpregado;
    }
}
