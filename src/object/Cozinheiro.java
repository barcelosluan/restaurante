package object;

import java.util.Date;

public class Cozinheiro extends Empregado{
    private Integer codEmpregado;

    private String fantasia;


    public Cozinheiro() {
    }

    public Cozinheiro(Integer codigo, String nome, Date data_contrato, String rg, String fantasia) {
        super(codigo, nome, data_contrato, rg);
        this.codEmpregado=codigo;
        this.fantasia=fantasia;
    }

    public Cozinheiro(Integer codEmpregado, String fantasia) {
        super();
        this.codEmpregado=codEmpregado;
        this.fantasia=fantasia;
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
}
