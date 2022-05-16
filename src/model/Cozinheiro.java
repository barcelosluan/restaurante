package model;

import java.util.Date;
import java.util.List;

public class Cozinheiro extends Empregado{
    private Integer codEmpregado;

    private String fantasia;

    private List<Restaurante> restaurantes;

    public Cozinheiro() {
    }

    public Cozinheiro(Integer codigo, String nome, Date data_contrato, String rg, String fantasia, List<Restaurante> restaurantes) {
        super(codigo, nome, data_contrato, rg);
        this.fantasia=fantasia;
        this.restaurantes = restaurantes;
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

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Restaurante restaurante) {
        this.restaurantes.add(restaurante);
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }
}
