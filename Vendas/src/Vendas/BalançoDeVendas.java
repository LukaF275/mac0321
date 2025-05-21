package Vendas;
import java.util.ArrayList;
import java.util.List;

public class BalançoDeVendas {

    private List<Venda> vendas;

    public BalançoDeVendas() {
        this.vendas = new ArrayList<>();
    }

    public void adicionaVenda(Venda v){
        vendas.add(v);
    }

   public void imprimeVendas(){
    for (Venda v : vendas) {
        System.out.println("Id:" + v.getIdItem() + " produto: "+ v.getNome()  + " preço: "+ v.getPreco());
    }
   }

   public double impostoPagoTotal(){
    double totalImpostos = 0.0;
    for (Venda v : vendas) {
        totalImpostos += v.impostoPago();
    }
    return totalImpostos;
   }

   public double receitaLiquida(){
    double receita = 0.0;
    for (Venda v : vendas) {
        receita += (v.valorTotal() - v.impostoPago() - v.frete());
    }
    return receita;
   }
}
