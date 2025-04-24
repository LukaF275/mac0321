package poligonos;

public class TriânguloEquilátero extends Triângulo{
    public TriânguloEquilátero(int lado,String cor){// Cria triangulo equilátero
        super(lado, lado, lado,cor);
    }

    public double calculaArea(){
        double area = (_lados[0]*_lados[1]*Math.sqrt(3))/2;
        return area;
    }

}
