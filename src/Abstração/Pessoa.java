package Abstração;

public class Pessoa {
    private String nome;
    private int idade;


    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome + " idade: " + idade);
    }

    private void fazerNiver() {
        this.idade += 1;
    }

    public void celebrarNiver() {
        fazerNiver();
        System.out.println("Hoje é o aniversário dele: " + this.nome + "! Parabéns, agora " + this.nome + " Tem " + this.idade);
    }


}
