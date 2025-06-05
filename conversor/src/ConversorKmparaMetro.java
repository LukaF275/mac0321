public class ConversorKmparaMetro implements Conversor {

    @Override
    public double converter(double quilometros) {
        return quilometros * 1000.0;
    }

    @Override
    public ConversorKmparaMetro clone() {
        return new ConversorKmparaMetro();
    }
    
}
