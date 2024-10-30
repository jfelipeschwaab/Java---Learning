package Revisão03;

public class Animal {
    public void comer() {
        System.out.println("O animal está comendo.");
    }

    public void dormir() {
        System.out.println("O animal está dormindo.");
    }

    public void fazerSom() {
        System.out.println("O animal faz um som.");
    }
}

class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("O cachorro faz: Au Au!");
    }
}

class Gato extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("O gato faz: Miau!");
    }
}
