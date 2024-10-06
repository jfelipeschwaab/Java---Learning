package Herança;

public class Veiculo {
    private String marca;
    private String modelo;
    private int velocidade;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = 0;
    }

    void acelerar() {
        System.out.println("Carro está acelerando");
        acelerarOCarro();
    }

    private void acelerarOCarro() {
        this.velocidade += 20;
    }

    void frear() {
        System.out.println("Carro está freiando");
        frearOCarro();

    }

    private void frearOCarro () {
        this.velocidade -= 20;
    }

    public void minhaVelocidade() {
        System.out.println("Você está a: " + this.velocidade + " Km/h");
    }
}

class Carro extends Veiculo {
    public Carro(String marca, String modelo) {
        super(marca,modelo);
    }


}
