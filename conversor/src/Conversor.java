/**
 * Interface de conversores de temperatura
*/
public interface Conversor extends Cloneable {
    double converter(double temperatura);
    Conversor clone();
}
