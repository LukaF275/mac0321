package Vendas;
public class VendaBrasil extends Venda{
    public VendaBrasil (String nome, double preco){
        super(nome, preco);
    }

    @Override
    public double valorTotal() {
        return 1.08*getPreco();
    }

    @Override
    public double impostoPago() {
        return 0.08*getPreco();
    }

    @Override
    public double frete() {
        return 30.00;
    }
}
