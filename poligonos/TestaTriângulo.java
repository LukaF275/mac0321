package poligonos;

public class TestaTriângulo {

   public static boolean testaArea(){
        Triângulo[] testes = {
            new Triângulo(3, 4, 5, ""),new TriânguloIsósceles(5,6,"seila")
        };
        
        double[] esperado = { 6.0, 12.0};

        for (int i = 0; i < testes.length; i++) {
            if(!testaCasoArea(testes[i], esperado[i])) return false;
        }
        return true;
    }

    public static boolean testaCasoArea(Triângulo t,double valorEsperado){
        double area = t.calculaArea();
        return (area == valorEsperado);
    }
    
    public static void main(String[] args) {
        System.out.println(testaArea());
    }
}