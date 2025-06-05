public class ConversorIdentidade implements Conversor {
    @Override
    public double converter(double temperatura) {
        return temperatura;
    }

    @Override
    public Conversor clone() {
        return new ConversorIdentidade();
    }
}

