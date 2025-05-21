class Conta_Corrente {
    //dados pessoais dos clientes (Nome, CPF, RG e Endereço),
    String nome;
    int cpf;
    int rg;
    String endereco;

    int agencia;
    int no_conta;
    double saldo;

    public Conta_Corrente (String nome, int cpf, int rg, String endereco, int agencia, int no_conta, double saldo){
        this.nome = nome;
        this.cpf  = cpf;
        this.rg  = rg;
        this.endereco = endereco;
        this.agencia = agencia;
        this.no_conta = no_conta;
        this.saldo = saldo;
    }

    public void verSaldo(){
        System.out.println("Saldo atual:" + saldo); 
    }

    public void sacar(double saque){

        if (saque > saldo) {
            System.out.println("Saldo Insuficiente");
        }
        else{
            this.saldo -= saque;
        }

    }

    public void depositar(double deposito){
        if (deposito <= 0) {
            System.out.println("Valor inválido!");
        }else{
            this.saldo += deposito;
        }
    }

    public void transferir (Conta_Corrente conta, double valor){
        this.saldo -= valor;
        conta.saldo += valor;
    }

    public void extrato(){
        System.out.print("Saldo: " + this.saldo +  " Agencia: " + this.agencia +  " Conta: "+ this.no_conta);
    }

}


 class Poupanca extends Conta_Corrente {

    public Poupanca (String nome, int cpf, int rg, String endereco, int agencia, int no_conta, double saldo){
        super(nome, cpf, rg, endereco, agencia, no_conta, saldo);
    }

    public void transferir (Conta_Corrente conta, double valor){
        if (conta.nome != this.nome) {
            System.out.println("Transação não autorizada");
        }else{
            this.saldo -= valor;
            conta.saldo += valor;
        }
    }
    
}

 class Comum extends Conta_Corrente {

    public Comum (String nome, int cpf, int rg, String endereco, int agencia, int no_conta, double saldo){
        super(nome, cpf, rg, endereco, agencia, no_conta, saldo);
    }
}

class Preferencial extends Conta_Corrente {

    public Preferencial (String nome, int cpf, int rg, String endereco, int agencia, int no_conta, double saldo){
        super(nome, cpf, rg, endereco, agencia, no_conta, saldo);
    }
}

public class Main {
    public static void main(String[] args) {
        Poupanca contaA = new Poupanca("Lucas", 8234506, 526712346, "Rua Amarildo Gonzales", 1234, 1, 33000);
        
        contaA.verSaldo();
        
        Comum contaB = new Comum("Maria", 123456789, 987654321, "Rua Nova", 1234, 2, 5000);
        Preferencial contaC = new Preferencial("João", 111223344, 445566778, "Avenida Central", 4321, 3, 10000);
        
        contaB.verSaldo();
        contaC.verSaldo();
        contaC.extrato();
    }
    
    
}



/*
    
 * 
 * 
 * Conta_Corrente -> Poupança,
 */