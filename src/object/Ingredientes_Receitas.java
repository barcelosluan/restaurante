package object;

public class Ingredientes_Receitas {
    private String receita;
    private Integer codCozinheiro;
    private Integer codIngrediente;
    private Double quantidade;
    private String medida;
    private String descricao;
    private String rendimento;

    public Ingredientes_Receitas(String receita, Integer codCozinheiro, Integer codIngrediente, Double quantidade, String medida, String descricao, String rendimento) {
        this.receita = receita;
        this.codCozinheiro = codCozinheiro;
        this.codIngrediente = codIngrediente;
        this.quantidade = quantidade;
        this.medida = medida;
        this.descricao = descricao;
        this.rendimento = rendimento;
    }

    public Ingredientes_Receitas() {
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public Integer getCodCozinheiro() {
        return codCozinheiro;
    }

    public void setCodCozinheiro(Integer codCozinheiro) {
        this.codCozinheiro = codCozinheiro;
    }

    public Integer getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(Integer codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }
}
