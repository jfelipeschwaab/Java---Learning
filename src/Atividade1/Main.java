package Atividade1;

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + this.nome + ", Idade: " + this.idade);
    }
}


class Aluno extends Pessoa {
    private String matricula;

    public Aluno(int idade, String nome, String matricula) {
        super(idade, nome);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    @Override
    public void exibirInfo() {
        System.out.println("Nome: " + getNome() + ", Idade: " + getIdade() + ", Matrícula: " + this.matricula);
    }
}


class Professor extends Pessoa {
    private double salario;

    public Professor(String nome, int idade, double salario) {
        super(idade, nome);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome: " + getNome() + ", Idade: " + getIdade() + ", Salário: R$" + String.format("%.2f", salario));
    }
}
public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(30, "João");
        pessoa.exibirInfo();

        Aluno aluno = new Aluno(20, "Maria", "A12345");
        aluno.exibirInfo();

        Professor professor = new Professor("Carlos", 45, 5500.00);
        professor.exibirInfo();
    }
}