package Mercado;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        boolean continuar = true;

        while(continuar) {
            String opcao = JOptionPane.showInputDialog(
                    "Escolha uma opção:\n" +
                            "1. Cadastro de novo produto ao estoque\n" +
                            "2. Mostrar o estoque\n" +
                            "3. Deletar Produto do estoque (Baseado no nome)\n" +
                            "4. Valor total em estoque (quantidade * preço) de todos os produtos\n" +
                            "5. Sair"
            );

            switch (opcao) {
                case "1":
                    cadastrarProduto(produtos);
                    break;

                case "2":
                    mostrarEstoque(produtos);
                    break;

                case "3":
                    deletarProduto(produtos);
                    break;

                case "4":
                    valorTotalEstoque(produtos);
                    break;

                case "5":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saindo do programa!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
            }
        }



    }

    public static void cadastrarProduto(ArrayList<Produto> produtos) {
        Produto produto = new Produto("", 0, 0);

        produto.setNome();
        produto.setPreco();
        produto.setQuantidade();

        produtos.add(produto);

        JOptionPane.showMessageDialog(null, "Produto Cadastrado");

    }

    public static void mostrarEstoque(ArrayList<Produto> produtos){
        if(produtos.isEmpty()){
            JOptionPane.showMessageDialog(null, "O estoque está vazio.");
            return;
        }

        StringBuilder estoque = new StringBuilder("Estoque:\n");

        for(Produto produto : produtos){
            estoque.append("Nome: ").append(produto.getNome()).append(", Preço: ").append(produto.getPreco()).append(", Quantidade: ").append(produto.getQuantidade()).append("\n");
        }
        JOptionPane.showMessageDialog(null, estoque.toString());
    }

    public static void deletarProduto(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O estoque está vazio");
            return;
        }

        String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto que você deseja deletar:");

        Produto produtoParaDeletar = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtoParaDeletar = produto;
                break;
            }
        }
        if (produtoParaDeletar != null) {
            produtos.remove(produtoParaDeletar);
            JOptionPane.showMessageDialog(null, "Produto Deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }



    }

    public static void valorTotalEstoque(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O estoque está vazio.");
            return;
        }

        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco() * produto.getQuantidade();
        }

        JOptionPane.showMessageDialog(null, "Valor total em estoque: R$ " + valorTotal);
    }
}
