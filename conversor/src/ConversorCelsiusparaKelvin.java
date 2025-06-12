public class ConversorCelsiusparaKelvin implements Conversor {

    @Override
    public double converter(double temperatura) {
        return temperatura + 273.15;
    }

    @Override
    public Conversor clone() {
        return new ConversorCelsiusparaKelvin();
    }

}