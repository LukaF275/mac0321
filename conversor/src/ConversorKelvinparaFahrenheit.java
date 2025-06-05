public class ConversorKelvinparaFahrenheit implements Conversor {
    @Override
    public double converter(double temperatura) {
        return (temperatura - 273.15) * 9 / 5 + 32;
    }

    @Override
    public Conversor clone() {
        return new ConversorKelvinparaFahrenheit();
    }
}
