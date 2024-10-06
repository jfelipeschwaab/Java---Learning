package Herança;

public class Main {
    public static void main(String[] args) {
        Pessoa eu = new Pessoa("João", 19);
        Amigo meuAmigo = new Amigo("Yago", 19);
        Carro meuCarro = new Carro("BMW", "B8");
        meuCarro.acelerar();
        meuCarro.acelerar();
        meuCarro.velocidade();
        meuCarro.buzinar();
        meuCarro.frear();
        meuCarro.detalhes();

    }
}
