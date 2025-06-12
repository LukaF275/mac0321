public class ConversorKmparaMilha implements Conversor {

    @Override
    public double converter(double quilometros) {
        return quilometros * 0.621371; // 1 quilômetro = 0.621371 milhas
    }

    @Override
    public ConversorKmparaMilha clone() {
        return new ConversorKmparaMilha();
    }
    
}
