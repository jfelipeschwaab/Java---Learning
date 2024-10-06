package Herança.Animal;

public abstract class Animal {
    private String nome;
    private int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void detalhes() {
        System.out.println("Nome: " + this.nome + ", Idade: " + this.idade + " anos");
    }

    public abstract void fazerSom();
    public abstract void mover();
}


class Gato extends Animal implements Domestico {
    private boolean estaBrincando;

    public Gato(String nome, int idade) {
        super(nome,idade);
        this.estaBrincando = false;
    }

    @Override
    public void fazerSom() {
        System.out.println("MIAUUU");
    }

    @Override
    public void mover() {
        System.out.println("O gato saiu de casa, silenciosamente");
    }

    @Override
    public void brincar() {
        this.estaBrincando = true;
        System.out.println("O gato está brincando com uma bola de lã");
    }

    @Override
    public void alimentar() {
        this.estaBrincando = false;
        System.out.println("O gato está comendo");
    }

    public void verificarEstado() {
        if(this.estaBrincando) {
            System.out.println("O gato está brincando.");
        }else{
            System.out.println("O gato está descansando");
        }
    }
}
