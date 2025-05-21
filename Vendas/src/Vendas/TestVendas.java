package Vendas;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestVendas {
    
    @Test
    public void TesteId(){
    Venda v1 = new VendaSP("Pão", 5.00);
    Venda v2 = new VendaBrasil("Caju", 10.00);
    assertEquals(v1.getIdItem(), 0);
    assertEquals(v2.getIdItem(), 1);
    }

    @Test
    public void testCalculosVendaSP() {
        VendaSP venda = new VendaSP("Notebook", 1000.0);

        assertEquals(1120.0, venda.valorTotal(), 0.001);

        assertEquals(120.0, venda.impostoPago(), 0.001);

        assertEquals(0.0, venda.frete(), 0.001);
    }

    @Test
    public void testCalculosVendaExterior() {
        VendaExterior venda = new VendaExterior("Celular", 2000.0);

        assertEquals(2000.0, venda.valorTotal(), 0.001);

        assertEquals(0.0, venda.impostoPago(), 0.001);

        assertEquals(100.0, venda.frete(), 0.001);
    }

    @Test
    public void testImpostoPagoTotalEReceitaLiquida() {
        BalançoDeVendas balanco = new BalançoDeVendas();

        balanco.adicionaVenda(new VendaSP("Livro", 100.0));     
        balanco.adicionaVenda(new VendaExterior("Tablet", 300.0));

        assertEquals(12.0, balanco.impostoPagoTotal(), 0.001);

        assertEquals(300.0, balanco.receitaLiquida(), 0.001);
    }
}
