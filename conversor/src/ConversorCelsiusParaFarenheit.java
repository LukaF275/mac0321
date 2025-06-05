
public class ConversorCelsiusParaFarenheit implements Conversor {

    @Override
    public double converte(double temperatura) {
        return 9*temperatura/5 + 32;
    }
   
}
