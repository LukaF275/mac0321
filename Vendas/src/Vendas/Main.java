package Vendas;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        BalançoDeVendas balanco = new BalançoDeVendas();
        
        System.out.println("Digite o número de vendas:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o local: 1 para SP, 2 para fora de SP e 3 para exterior");
            int local = scanner.nextInt();
            scanner.nextLine(); 
            
            String nome;
            double preco;

            System.out.println("Digite o nome do produto: ");
            nome = scanner.nextLine();
            System.out.println("Preço do produto: ");
            preco = scanner.nextDouble();

            if (local == 1) {
                balanco.adicionaVenda(new VendaSP(nome, preco));
            }
            if (local == 2) {
                balanco.adicionaVenda(new VendaBrasil(nome, preco));
            }
            if (local == 3) {
                balanco.adicionaVenda(new VendaExterior(nome, preco));
            }
        }
        System.out.println("Relatório: ");

        balanco.imprimeVendas();

        System.out.println("imposto Total: ");

        System.out.println(balanco.impostoPagoTotal());

        scanner.close();
    }
}
