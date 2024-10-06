package Herança;

public class Veiculo {
    private String marca;
    private String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void detalhes() {
        System.out.println("Marca: " + this.marca + ", Modelo: " + this.modelo);
    }

}

class Carro extends Veiculo implements VeiculoAçoes {
    private int velocidade;
    public Carro(String marca, String modelo) {
        super(marca,modelo);
        this.velocidade = 0;
    }

    @Override
    public void acelerar() {
        System.out.println("O carro está acelerando!");
        this.velocidade += 20;
    }

    @Override
    public void frear() {
        System.out.println("O carro está freando");
        this.velocidade -= 20;
    }

    @Override
    public void buzinar() {
        System.out.println("BIBIIIII");
    }

    public void velocidade(){
        System.out.println("Você está a " + this.velocidade + " KM/H");
    }







}
