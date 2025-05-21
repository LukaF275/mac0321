package Vendas;
public class VendaSP extends Venda {
    public VendaSP(String nome,double preco){
        super( nome, preco);
    }

    @Override
    public double valorTotal() {
        return (1.12*getPreco());
    }

    @Override
    public double impostoPago() {
        return (0.12*getPreco());
    }

    @Override
    public double frete() {
        return 0;
    }
}
