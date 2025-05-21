import java.io.*;
import java.net.*;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Uso: java CalculatorClient <host> <porta>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in))
        ) {
            System.out.println("Conectado ao servidor de calculadora.");

            System.out.print("Digite o primeiro número: ");
            String num1 = stdIn.readLine();
            System.out.print("Digite o segundo número: ");
            String num2 = stdIn.readLine();

            out.println(num1);
            out.println(num2);

            String response = in.readLine();
            System.out.println("Resposta do servidor: " + response);
        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erro de I/O ao conectar ao host " + hostName);
            System.exit(1);
        }
    }
}
