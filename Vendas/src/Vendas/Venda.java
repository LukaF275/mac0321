package Vendas;


public abstract class Venda {

    private static int proxIdItem = 0;
    private final int idItem;
    private String nome;
    private double preco;

    public Venda(String nome, double preco) {
        this.idItem = proxIdItem ++;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters
    public int getIdItem() {
        return idItem;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Métodos abstratos
    public abstract double valorTotal();
    public abstract double impostoPago();
    public abstract double frete();
}
