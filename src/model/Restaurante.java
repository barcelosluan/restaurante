package model;

public class Restaurante {
    private Integer codigo;

    public Restaurante(Integer codigo) {
        this.codigo = codigo;
    }

    public Restaurante() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
