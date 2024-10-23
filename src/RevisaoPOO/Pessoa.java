package RevisaoPOO;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

class Funcionario extends Pessoa {
    private double salario;
    private String cargo;

    public Funcionario(String nome, int idade, double salario, String cargo) {
        super(nome, idade);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double calcularSalarioAnual() {
        return salario * 12;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Cargo: " + cargo + ", Salário Mensal: " + salario);
    }
}

