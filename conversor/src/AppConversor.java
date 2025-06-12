public class AppConversor {
    public static void main(String[] args) {
        ConversorFactory fabrica = ConversorFactory.getInstance();

        Conversor conv1 = fabrica.criarConversor(TipoConversor.CELSIUS_PARA_FAHRENHEIT);
        Conversor conv2 = fabrica.criarConversor(TipoConversor.FAHRENHEIT_PARA_CELSIUS);
        Conversor conv3 = fabrica.criarConversor(TipoConversor.CELSIUS_PARA_KELVIN);
        Conversor conv4 = fabrica.criarConversor(TipoConversor.KELVIN_PARA_CELSIUS);
        Conversor conv5 = fabrica.criarConversor(TipoConversor.FAHRENHEIT_PARA_KELVIN);
        Conversor conv6 = fabrica.criarConversor(TipoConversor.KELVIN_PARA_FAHRENHEIT);
        Conversor conv7 = fabrica.criarConversor(TipoConversor.IDENTIDADE);
        Conversor conv8 = fabrica.criarConversor(TipoConversor.METROS_PARA_QUILOMETROS);
        Conversor conv9 = fabrica.criarConversor(TipoConversor.QUILOMETROS_PARA_METROS);
        Conversor conv10 = fabrica.criarConversor(TipoConversor.MILHAS_PARA_QUILOMETROS);
        Conversor conv11 = fabrica.criarConversor(TipoConversor.QUILOMETROS_PARA_MILHAS);

        System.out.println("25 ºC -> " + conv1.converter(25) + " ºF");
        System.out.println("77 ºF -> " + conv2.converter(77) + " ºC");
        System.out.println("0 ºC -> " + conv3.converter(0) + " K");
        System.out.println("273.15 K -> " + conv4.converter(273.15) + " ºC");
        System.out.println("32 ºF -> " + conv5.converter(32) + " K");
        System.out.println("273.15 K -> " + conv6.converter(273.15) + " ºF");
        System.out.println("100 ºC -> " + conv7.converter(100) + " ºC");
        System.out.println("100 m -> " + conv7.converter(100) + " km");
        System.out.println("1 km -> " + conv8.converter(1) + " m");
        System.out.println("1 km -> " + conv9.converter(1) + " m");
        System.out.println("1 milha -> " + conv10.converter(1) + " km");
        System.out.println("1 km -> " + conv11.converter(1) + " milha");
    }
}
