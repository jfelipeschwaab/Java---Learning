package Revisão03;

import java.util.List;

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public double somar(double a, double b) {
        return a + b;
    }

    public int somar(List<Integer> numeros) {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("Soma de dois inteiros: " + calculadora.somar(3, 5));

        System.out.println("Soma de dois doubles: " + calculadora.somar(3.5, 2.7));

        List<Integer> lista = List.of(1, 2, 3, 4, 5);
        System.out.println("Soma de uma lista de inteiros: " + calculadora.somar(lista));
    }
}

