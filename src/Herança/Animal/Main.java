package Herança.Animal;

public class Main {
    public static void main(String[] args) {
        // Cria um gato
        Gato meuGato = new Gato("Aurora", 3);
        int numeroDePatas = Gato.obterNumeroDePatas();
        System.out.println("Número típico de patas de um gato: " + numeroDePatas);

        // Usa métodos da classe abstrata
        meuGato.detalhes(); // Método concreto da classe abstrata
        meuGato.fazerSom(); // Método abstrato implementado na subclasse
        meuGato.mover();    // Método abstrato implementado na subclasse

        //métodos da interface Domestico
        meuGato.brincar();
        meuGato.alimentar();

        //método específico da classe Gato
        meuGato.verificarEstado();
    }
}