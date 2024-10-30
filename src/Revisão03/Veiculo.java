package Revisão03;

abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private double precoPorDia;

    public Veiculo(String placa, String marca, String modelo, int ano, double precoPorDia) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.precoPorDia = precoPorDia;
    }

    public String getInfo() {
        return "Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano;
    }

    public double calcularValorLocacao(int dias) {
        return precoPorDia * dias;
    }

    public double getPrecoPorDia() {
        return precoPorDia;
    }
}

class Carro extends Veiculo {
    private int quantidadeDePortas;

    public Carro(String placa, String marca, String modelo, int ano, double precoPorDia, int quantidadeDePortas) {
        super(placa, marca, modelo, ano, precoPorDia);
        this.quantidadeDePortas = quantidadeDePortas;
    }

    @Override
    public double calcularValorLocacao(int dias) {
        double valorTotal = super.calcularValorLocacao(dias);
        if (dias > 7) {
            valorTotal *= 0.95;
        }
        return valorTotal;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Portas: " + quantidadeDePortas;
    }
}

class Moto extends Veiculo {
    private int cilindrada;

    public Moto(String placa, String marca, String modelo, int ano, double precoPorDia, int cilindrada) {
        super(placa, marca, modelo, ano, precoPorDia);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularValorLocacao(int dias) {
        double valorTotal = super.calcularValorLocacao(dias);
        valorTotal *= 1.10; // Aplicando acréscimo de 10%
        return valorTotal;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Cilindrada: " + cilindrada;
    }
}


