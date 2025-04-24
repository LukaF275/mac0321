package poligonos;

public class Triângulo extends Polígono{

    private String cor;
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Triângulo (int lado1,int lado2,int lado3,String cor){
        super(new int[]{lado1,lado2,lado3}, "Triângulo");
        this.cor = cor;
    }

    private boolean eValido(Triângulo t){

        if (_lados[0] +_lados[1] < _lados[2] || 
        _lados[1] +_lados[2] < _lados[0] || 
        _lados[0] +_lados[2] < _lados[1] ) {
            return false;
        }
        return true;
    }

    public double calculaArea(){
        double s = calculaPerímetro()/2;
        double area = (s*(s-_lados[0])*(s-_lados[1])*(s-_lados[2]));
        return Math.sqrt(area);
    }

    public String toString(){
        return "Sou um triangulo com perimetro " + calculaPerímetro() + " cm e cor "+ cor ;
    }
}
