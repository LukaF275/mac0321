public class ConversorMetrosparaKm implements Conversor {

    public double converter(double metros) {
        return metros / 1000.0;
    }

    public ConversorMetrosparaKm clone() {
        return new ConversorMetrosparaKm();
    }
}