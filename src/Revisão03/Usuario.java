package Revisão03;

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nome;
    private int idUsuario;
    private List<ItemBiblioteca> itensEmprestados;

    public Usuario(String nome, int idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.itensEmprestados = new ArrayList<>();
    }

    public void emprestarItem(ItemBiblioteca item) {
        itensEmprestados.add(item);
        System.out.println("Item emprestado: " + item.getInfo());
    }

    public void devolverItem(ItemBiblioteca item) {
        if (itensEmprestados.remove(item)) {
            System.out.println("Item devolvido: " + item.getInfo());
        } else {
            System.out.println("O item não está na lista de itens emprestados.");
        }
    }

    public void mostrarItensEmprestados() {
        System.out.println("Itens emprestados por " + nome + ":");
        for (ItemBiblioteca item : itensEmprestados) {
            System.out.println(item.getInfo());
        }
    }
}
