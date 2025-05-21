import java.io.*;
import java.net.*;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Uso: java CalculatorServer <porta>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            System.out.println("Cliente conectado. Aguardando dois números inteiros...");

            String firstNumberStr = in.readLine();
            String secondNumberStr = in.readLine();

            if (firstNumberStr != null && secondNumberStr != null) {
                try {
                    int num1 = Integer.parseInt(firstNumberStr.trim());
                    int num2 = Integer.parseInt(secondNumberStr.trim());
                    int result = num1 + num2;
                    out.println("Resultado da soma: " + result);
                } catch (NumberFormatException e) {
                    out.println("Erro: entrada inválida.");
                }
            }

            System.out.println("Encerrando servidor.");
        } catch (IOException e) {
            System.err.println("Erro ao escutar na porta " + portNumber);
            System.err.println(e.getMessage());
        }
    }
}
