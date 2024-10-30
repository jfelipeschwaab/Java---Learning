package Revisão03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContaBancaria minhaConta = new ContaBancaria();
        minhaConta.setTitular("João Felipe");
        minhaConta.getTitular();
        minhaConta.ConsultarSaldo();
        minhaConta.Depositar();
        minhaConta.ConsultarSaldo();
        minhaConta.Sacar();

        List<Forma> formas = new ArrayList<>();

        formas.add(new Circulo(5.0));
        formas.add(new Retangulo(4.0, 6.0));
        formas.add(new Circulo(3.0));
        formas.add(new Retangulo(2.0, 3.0));

        for (Forma forma : formas) {
            System.out.println("Área da forma: " + forma.calcularArea());
        }

        Veiculo carro = new Carro("ABC1234", "Toyota", "Corolla", 2020, 150.0, 4);
        Veiculo moto = new Moto("XYZ5678", "Honda", "CB500", 2021, 100.0, 500);

        Cliente cliente = new Cliente("João Silva", "123.456.789-00");

        cliente.alugarVeiculo(carro, 10);
        cliente.alugarVeiculo(moto, 3);

        cliente.mostrarHistoricoDeLocacoes();

        Livro livro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Fantasia");
        Revista revista = new Revista("National Geographic", "Vários Autores", 2023, 330);

        Usuario usuario = new Usuario("Alice", 101);

        usuario.emprestarItem(livro);
        usuario.emprestarItem(revista);

        usuario.mostrarItensEmprestados();

        usuario.devolverItem(livro);
        usuario.mostrarItensEmprestados();
    }
}
