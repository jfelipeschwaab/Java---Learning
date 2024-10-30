package Revisão03;
import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nome;
    private String cpf;
    private List<String> historicoDeLocacoes;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.historicoDeLocacoes = new ArrayList<>();
    }

    public void alugarVeiculo(Veiculo veiculo, int dias) {
        double custo = veiculo.calcularValorLocacao(dias);
        historicoDeLocacoes.add(veiculo.getInfo() + ", Dias: " + dias + ", Custo: R$ " + custo);
    }

    public void mostrarHistoricoDeLocacoes() {
        System.out.println("Histórico de Locações de " + nome + ":");
        for (String locacao : historicoDeLocacoes) {
            System.out.println(locacao);
        }
    }
}

