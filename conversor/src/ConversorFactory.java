import java.util.HashMap;
import java.util.Map;

public class ConversorFactory {
    private static ConversorFactory instancia = new ConversorFactory();
    private Map<TipoConversor, Conversor> prototipos;

    private ConversorFactory() {
        prototipos = new HashMap<>();

        prototipos.put(TipoConversor.CELSIUS_PARA_FAHRENHEIT, new ConversorCelsiusparaFahrenheit());
        prototipos.put(TipoConversor.FAHRENHEIT_PARA_CELSIUS, new ConversorFarenheitParaCelsius());
        prototipos.put(TipoConversor.CELSIUS_PARA_KELVIN, new ConversorCelsiusparaKelvin());
        prototipos.put(TipoConversor.KELVIN_PARA_CELSIUS, new ConversorKelvinparaCelsius());
        prototipos.put(TipoConversor.FAHRENHEIT_PARA_KELVIN, new ConversorFarenheitparaKelvin());
        prototipos.put(TipoConversor.KELVIN_PARA_FAHRENHEIT, new ConversorKelvinparaFahrenheit());
        prototipos.put(TipoConversor.IDENTIDADE, new ConversorIdentidade());
    }

    public static ConversorFactory getInstance() {
        return instancia;
    }

    public Conversor criarConversor(TipoConversor tipo) {
        Conversor prototipo = prototipos.get(tipo);
        return prototipo != null ? prototipo.clone() : null;
    }
}
