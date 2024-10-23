package RevisaoPOO;

import java.util.ArrayList;
import java.util.List;

abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public abstract void exibirInformacoes();
}

class Carro extends Veiculo {
    public Carro(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Carro: " + marca + " " + modelo + ", Ano: " + ano);
    }
}

class Moto extends Veiculo {
    public Moto(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Moto: " + marca + " " + modelo + ", Ano: " + ano);
    }
}

public class Concessionaria {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(String modelo) {
        veiculos.removeIf(veiculo -> veiculo.modelo.equals(modelo));
    }

    public void listarVeiculos() {
        for (Veiculo veiculo : veiculos) {
            veiculo.exibirInformacoes();
        }
    }
}
