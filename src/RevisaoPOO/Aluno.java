package RevisaoPOO;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }
}

class Turma {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(String nome) {
        alunos.removeIf(aluno -> aluno.getNome().equals(nome));
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome() + ", Nota: " + aluno.getNota());
        }
    }

    public double calcularMedia() {
        if (alunos.isEmpty()) {
            return 0;
        }
        double totalNotas = 0;
        for (Aluno aluno : alunos) {
            totalNotas += aluno.getNota();
        }
        return totalNotas / alunos.size();
    }
}
