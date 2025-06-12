public class ConversorCelsiusparaFahrenheit implements Conversor {
    @Override
    public double converter(double temperatura) {
        return temperatura * 9 / 5 + 32;
    }

    @Override
    public Conversor clone() {
        return new ConversorCelsiusparaFahrenheit();
    }
}
