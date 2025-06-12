public class ConversorFarenheitparaKelvin implements Conversor {


    @Override
    public double converter(double temperatura) {
        return (temperatura - 32) * 5 / 9 + 273.15;
    }

    @Override
    public Conversor clone() {
        return new ConversorFarenheitparaKelvin();
    }
    
}
