public class ConversorFarenheitParaCelsius implements Conversor {
    @Override
    public double converter(double temperatura) {
        return (temperatura - 32) * 5 / 9;
    }

    @Override
    public Conversor clone() {
        return new ConversorFarenheitParaCelsius();
    }
}


