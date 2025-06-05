public class ConversorFarenheitParaCelsius implements Conversor {

    @Override
    public double converte(double temperatura) {
        return 5*(temperatura-32)/9;    
    }
    
}
