package Vendas;
public class VendaExterior extends Venda{
    public VendaExterior(String nome,double preco){
        super(nome, preco);
    }

    @Override
    public double valorTotal() {
        return getPreco();
    }

    @Override
    public double impostoPago() {
        return 0;
    }
    @Override
    public double frete() {
        return 100.00;
    }
}
