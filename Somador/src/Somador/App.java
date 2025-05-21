package Somador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Verifica se o arquivo de entrada foi passado como argumento
        if (args.length < 1) {
            System.out.println("Use: java Somador.App <arquivo_entrada>");
            return;
        }

        File arquivoEntrada = new File(args[0]);
        if (!arquivoEntrada.exists()) {
            System.out.println("Arquivo de entrada não encontrado: " + args[0]);
            return;
        }

        try (Scanner entrada = new Scanner(arquivoEntrada);
             PrintWriter saida = new PrintWriter(new File("saida.txt"))) {

            ArrayList<Integer> numeros = new ArrayList<>();

            // Lê todos os números do arquivo
            while (entrada.hasNext()) {
                if (entrada.hasNextInt()) {
                    numeros.add(entrada.nextInt());
                } else {
                    entrada.next(); // ignora tokens que não são inteiros
                }
            }

            // Soma os pares de números e escreve no arquivo saída
            for (int i = 0; i < numeros.size() - 1; i += 2) {
                int soma = numeros.get(i) + numeros.get(i + 1);
                saida.print(soma + " ");
            }

            System.out.println("Processamento concluído. Resultado salvo em 'saida.txt'.");

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
        
    }
}
