package Model;

public class Produto {

    private int id_Produto;
    private String nome;
    private Double valor;
    private Integer quantidade;

    public Produto() {
    }

    public int getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        this.id_Produto = id_Produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String toMostra(){
        return "Produto "+id_Produto+ ":\n"+
                "   Nome: " + nome + "; \n" +
                "   Preço: " + valor + "; \n"+
                "   Quantidade: " + quantidade + ";";
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id_Produto=" + id_Produto +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
