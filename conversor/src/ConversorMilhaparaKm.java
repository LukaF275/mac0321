public class ConversorMilhaparaKm implements Conversor {

    @Override
    public double converter(double milhas) {
        return milhas * 1.60934; // 1 milha = 1.60934 km
    }

    @Override
    public ConversorMilhaparaKm clone() {
        return new ConversorMilhaparaKm();
    }
    
}
