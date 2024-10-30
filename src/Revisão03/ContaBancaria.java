package Revisão03;
import java.util.Random;
import java.util.Scanner;



public class ContaBancaria {
    private float saldo;
    private String titular;
    private int numeroDaConta;
    Scanner scanner = new Scanner(System.in);


    public ContaBancaria() {
        this.numeroDaConta = gerarNumeroConta();
        this.titular = "";
        this.saldo = 0;
    }

    private int gerarNumeroConta() {
        Random random = new Random();
        this.numeroDaConta = random.nextInt(1000000);

        return this.numeroDaConta;
    }

    public void Depositar() {
        System.out.println("Digite o quanto você quer depositar:");
        float quantidade = scanner.nextFloat();
        ColocarNoSistema(quantidade);
    }

    private void ColocarNoSistema(float qtd) {
        this.saldo += qtd;
    }

    public void Sacar() {
        System.out.println("Digite o quanto você quer sacar:");
        float qtd = scanner.nextFloat();
        if(qtd > this.saldo) {
            System.out.println("Você possui saldo insuficiente!");
        }
        else{
            Debitar(qtd);
        }
    }

    private void Debitar(float qtd) {
        this.saldo -= qtd;
    }

    public void ConsultarSaldo() {
        System.out.println("Seu saldo é de: R$" + this.saldo);
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void getTitular() {
        System.out.println("O titular desta conta é: " + this.titular );
    }
}
