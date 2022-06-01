package object;

public class Cozinheiro_Restaurante {
    private Integer codCozinheiro;
    private Integer codRestaurante;

    public Cozinheiro_Restaurante(Integer cozinheiro, Integer restaurante) {
        this.codCozinheiro = cozinheiro;
        this.codRestaurante = restaurante;
    }

    public Cozinheiro_Restaurante() {
    }

    public Integer getCozinheiro() {
        return codCozinheiro;
    }

    public void setCozinheiro(Integer cozinheiro) {
        this.codCozinheiro = cozinheiro;
    }

    public Integer getCodRestaurante() {
        return codRestaurante;
    }

    public void setCodRestaurante(Integer codRestaurante) {
        this.codRestaurante = codRestaurante;
    }
}
