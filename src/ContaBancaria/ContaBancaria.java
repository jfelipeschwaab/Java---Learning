package ContaBancaria;

import java.text.DecimalFormat;

public class ContaBancaria {
    private String titular;
    private int numeroConta;
    private double saldo = 0;


    private static final DecimalFormat df = new DecimalFormat("R$ 0.00");

    public ContaBancaria() {
        this.titular = "";
        this.numeroConta = 0;
        this.saldo = 0;
    }


    public String getTitular() {
        return this.titular;
    }


    public int getNumeroConta() {
        return this.numeroConta;
    }


    public String getSaldo() {
        return df.format(this.saldo);
    }


    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setNumeroConta(String numeroConta) {
        if (numeroConta.length() == 5) {
            try {
                this.numeroConta = Integer.parseInt(numeroConta);
            } catch (NumberFormatException e) {
                System.out.println("Número da conta inválido. Certifique-se de que contém apenas dígitos.");
            }
        } else {
            System.out.println("O número da conta deve conter exatamente 5 dígitos.");
        }
    }


    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        } else {
            return false;
        }
    }


    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }
}
