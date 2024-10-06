package Herança;

public class Pessoa {
    private int idade;
    private String nome;
    private int Altura;
    private String corCabelo;


    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    void getNome() {
        System.out.println(this.nome);
    }
}

class Amigo extends Pessoa {
    public Amigo(String nome, int idade) {
        super(nome, idade);
    }


    void getNome() {
        super.getNome();
        System.out.println("Método da subclasse");
    }
}



