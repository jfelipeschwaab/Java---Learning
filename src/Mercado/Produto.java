package Mercado;

import javax.swing.*;

public class Produto {
    String nome;
    double Preco;
    int Quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.Preco = preco;
        this.Quantidade = quantidade;
    }

    public String getNome(){
        return nome;
    }

    public void setNome() {
        String novoNome = JOptionPane.showInputDialog("Digite o nome do produto");
        this.nome = novoNome;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(){
        String precoStr = JOptionPane.showInputDialog("Digite o preço do seu produto");
        try {
            double novoPreco = Double.parseDouble((precoStr));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Valor inválido, digite um número válido para o preço");
        }
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade() {
        String quantidadeStr = JOptionPane.showInputDialog("Digite a quantidade que você deseja desse produto");
         try {
             int novaQuantidade = Integer.parseInt(quantidadeStr);
             this.Quantidade = novaQuantidade;
         } catch(NumberFormatException e) {
             JOptionPane.showMessageDialog(null, "Valor inválido, digite um número válido para o preço");
         }
    }
}
