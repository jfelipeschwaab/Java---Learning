package Mercado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Produto {
    private String nome;
    private int quantidade;
    private double valor;

    public Produto(String nome, int quantidade, double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nome do produto: " + nome + ", Quantidade em estoque: " + quantidade + ", Valor: R$" + String.format("%.2f", valor);
    }
}

class Carrinho {
    private ArrayList<Produto> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        for (Produto item : itens) {
            if (item.getNome().equalsIgnoreCase(produto.getNome())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        Produto novoItem = new Produto(produto.getNome(), quantidade, produto.getValor());
        itens.add(novoItem);
    }

    public void removerProduto(String nome) {
        Iterator<Produto> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Produto item = iterator.next();
            if (item.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Produto não encontrado no carrinho.");
    }

    public void atualizarQuantidade(String nome, int novaQuantidade) {
        for (Produto item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                if (novaQuantidade <= 0) {
                    removerProduto(nome);
                } else {
                    item.setQuantidade(novaQuantidade);
                }
                return;
            }
        }
        System.out.println("Produto não encontrado no carrinho.");
    }

    public void visualizarCarrinho() {
        System.out.println("\n--- Carrinho de Compras ---");
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            double total = 0;
            for (Produto item : itens) {
                double subtotal = item.getQuantidade() * item.getValor();
                System.out.println(item + " (Subtotal: R$" + String.format("%.2f", subtotal) + ")");
                total += subtotal;
            }
            System.out.println("Total do carrinho: R$" + String.format("%.2f", total));
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto item : itens) {
            total += item.getQuantidade() * item.getValor();
        }
        return total;
    }

    public void finalizarCompra() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio. Adicione produtos antes de finalizar a compra.");
        } else {
            double total = calcularTotal();
            System.out.println("\n--- Finalizando Compra ---");
            visualizarCarrinho();
            System.out.println("Total a pagar: R$" + String.format("%.2f", total));
            itens.clear();
            System.out.println("Compra finalizada com sucesso!");
        }
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        Carrinho carrinho = new Carrinho();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== Sistema de Mercado =====");
            System.out.println("1. Cadastro de Produtos");
            System.out.println("2. Ver Produtos");
            System.out.println("3. Adicionar ao Carrinho");
            System.out.println("4. Ver Carrinho");
            System.out.println("5. Atualizar um Produto");
            System.out.println("6. Atualizar Carrinho");
            System.out.println("7. Finalizar Compra");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());


            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Produtos ---");
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    double valorDoProduto = 0;
                    while (true) {
                        try {
                            System.out.print("Digite o valor do produto: R$");
                            valorDoProduto = Double.parseDouble(scanner.nextLine());
                            if (valorDoProduto < 0) {
                                System.out.println("O valor não pode ser negativo.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido. Tente novamente.");
                        }
                    }

                    int quantidade = 0;
                    while (true) {
                        try {
                            System.out.print("Digite a quantidade em estoque: ");
                            quantidade = Integer.parseInt(scanner.nextLine());
                            if (quantidade < 0) {
                                System.out.println("A quantidade não pode ser negativa.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Quantidade inválida. Tente novamente.");
                        }
                    }

                    Produto novoProduto = new Produto(nome, quantidade, valorDoProduto);
                    produtos.add(novoProduto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Produtos ---");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        int indexProdutos = 1;
                        for (Produto produto : produtos) {
                            System.out.println(indexProdutos + ". " + produto);
                            indexProdutos++;
                        }
                    }
                    break;

                case 3:
                    if (produtos.isEmpty()) {
                        System.out.println("\nNenhum produto disponível para adicionar ao carrinho.");
                        break;
                    }
                    System.out.println("\n--- Adicionar ao Carrinho ---");
                    int indexDoProduto = 1;
                    for (Produto produto : produtos) {
                        System.out.println(indexDoProduto + ". " + produto);
                        indexDoProduto++;
                    }
                    int escolha = 0;
                    while (true) {
                        try {
                            System.out.print("Escolha o número do produto para adicionar ao carrinho (0 para cancelar): ");
                            escolha = Integer.parseInt(scanner.nextLine());
                            if (escolha == 0) {
                                break;
                            }
                            if (escolha < 1 || escolha > produtos.size()) {
                                System.out.println("Escolha inválida. Tente novamente.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Tente novamente.");
                        }
                    }
                    if (escolha == 0) {
                        break;
                    }
                    Produto produtoSelecionado = produtos.get(escolha - 1);
                    int qntdAdicionar = 0;
                    while (true) {
                        try {
                            System.out.print("Digite a quantidade que deseja adicionar: ");
                            qntdAdicionar = Integer.parseInt(scanner.nextLine());
                            if (qntdAdicionar <= 0) {
                                System.out.println("A quantidade deve ser maior que zero.");
                                continue;
                            }
                            if (qntdAdicionar > produtoSelecionado.getQuantidade()) {
                                System.out.println("Quantidade indisponível em estoque.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Quantidade inválida. Tente novamente.");
                        }
                    }
                    carrinho.adicionarProduto(produtoSelecionado, qntdAdicionar);
                    produtoSelecionado.setQuantidade(produtoSelecionado.getQuantidade() - qntdAdicionar);
                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                    break;

                case 4:
                    carrinho.visualizarCarrinho();
                    break;

                case 5:
                    if (produtos.isEmpty()) {
                        System.out.println("\nNenhum produto cadastrado para atualizar.");
                        break;
                    }
                    System.out.println("\n--- Atualizar Produto ---");
                    indexDoProduto = 1;
                    for (Produto produtoEstoque : produtos) {
                        System.out.println(indexDoProduto + ". " + produtoEstoque);
                        indexDoProduto++;
                    }
                    while (true) {
                        try {
                            System.out.print("Escolha o número do produto para atualizar (0 para cancelar): ");
                            escolha = Integer.parseInt(scanner.nextLine());
                            if (escolha == 0) {
                                break;
                            }
                            if (escolha < 1 || escolha > produtos.size()) {
                                System.out.println("Escolha inválida. Tente novamente.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException error) {
                            System.out.println("Entrada inválida. Tente novamente.");
                        }
                    }
                    if (escolha == 0) {
                        break;
                    }
                    Produto produtoAtualizar = produtos.get(escolha - 1);
                    System.out.print("Digite o novo nome do produto (ou pressione Enter para manter \"" + produtoAtualizar.getNome() + "\"): ");
                    String novoNome = scanner.nextLine();
                    if (!novoNome.trim().isEmpty()) {
                        produtoAtualizar.setNome(novoNome);
                    }

                    while (true) {
                        try {
                            System.out.print("Digite o novo valor do produto (ou pressione Enter para manter R$" + String.format("%.2f", produtoAtualizar.getValor()) + "): ");
                            String entradaValor = scanner.nextLine();
                            if (entradaValor.trim().isEmpty()) {
                                break;
                            }
                            double novoValor = Double.parseDouble(entradaValor);
                            if (novoValor < 0) {
                                System.out.println("O valor não pode ser negativo.");
                                continue;
                            }
                            produtoAtualizar.setValor(novoValor);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido. Tente novamente.");
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("Digite a nova quantidade em estoque (ou pressione Enter para manter " + produtoAtualizar.getQuantidade() + "): ");
                            String entradaQtd = scanner.nextLine();
                            if (entradaQtd.trim().isEmpty()) {
                                break;
                            }
                            int novaQtd = Integer.parseInt(entradaQtd);
                            if (novaQtd < 0) {
                                System.out.println("A quantidade não pode ser negativa.");
                                continue;
                            }
                            produtoAtualizar.setQuantidade(novaQtd);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Quantidade inválida. Tente novamente.");
                        }
                    }

                    System.out.println("Produto atualizado com sucesso!");
                    break;

                case 6:
                    carrinho.visualizarCarrinho();
                    if (carrinho.calcularTotal() == 0) {
                        break;
                    }
                    System.out.println("\n--- Atualizar Carrinho ---");
                    System.out.println("1. Atualizar Quantidade de um Produto");
                    System.out.println("2. Remover Produto do Carrinho");
                    System.out.println("0. Voltar");
                    System.out.print("Escolha uma opção: ");
                    int subOpcao = -1;
                    try {
                        subOpcao = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException error) {
                        subOpcao = -1;
                    }

                    switch (subOpcao) {
                        case 1:
                            System.out.print("Digite o nome do produto que deseja atualizar: ");
                            String nomeDoProdutoParaAtualizar = scanner.nextLine();
                            System.out.print("Digite a nova quantidade: ");
                            int novaQuantidadeDoProduto = 0;
                            try {
                                novaQuantidadeDoProduto = Integer.parseInt(scanner.nextLine());
                                if (novaQuantidadeDoProduto < 0) {
                                    System.out.println("A quantidade não pode ser negativa.");
                                    break;
                                }
                            } catch (NumberFormatException error) {
                                System.out.println("Quantidade inválida.");
                                break;
                            }
                            Produto produtoNoCarrinho = null;
                            for (Produto itemDoCarrinho : carrinho.getItens()) { // Usando getter
                                if (itemDoCarrinho.getNome().equalsIgnoreCase(nomeDoProdutoParaAtualizar)) {
                                    produtoNoCarrinho = itemDoCarrinho;
                                    break;
                                }
                            }
                            if (produtoNoCarrinho == null) {
                                System.out.println("Produto não encontrado no carrinho.");
                                break;
                            }
                            int diferencaDaQuantidadeDeProdutos = novaQuantidadeDoProduto - produtoNoCarrinho.getQuantidade();
                            Produto produtoOrigem = null;
                            for (Produto produtoCarrinho : produtos) {
                                if (produtoCarrinho.getNome().equalsIgnoreCase(nomeDoProdutoParaAtualizar)) {
                                    produtoOrigem = produtoCarrinho;
                                    break;
                                }
                            }
                            if (produtoOrigem == null) {
                                System.out.println("Produto original não encontrado no estoque.");
                                break;
                            }
                            if (diferencaDaQuantidadeDeProdutos > 0 && diferencaDaQuantidadeDeProdutos > produtoOrigem.getQuantidade()) {
                                System.out.println("Quantidade indisponível no estoque.");
                                break;
                            }
                            carrinho.atualizarQuantidade(nomeDoProdutoParaAtualizar, novaQuantidadeDoProduto);
                            if (diferencaDaQuantidadeDeProdutos > 0) {
                                produtoOrigem.setQuantidade(produtoOrigem.getQuantidade() - diferencaDaQuantidadeDeProdutos);
                            } else {
                                produtoOrigem.setQuantidade(produtoOrigem.getQuantidade() - diferencaDaQuantidadeDeProdutos);
                            }
                            System.out.println("Carrinho atualizado com sucesso!");
                            break;

                        case 2:
                            System.out.print("Digite o nome do produto que deseja remover: ");
                            String nomeRemover = scanner.nextLine();
                            Produto produtoParaRemover = null;
                            for (Produto itemDoCarrinho : carrinho.getItens()) {
                                if (itemDoCarrinho.getNome().equalsIgnoreCase(nomeRemover)) {
                                    produtoParaRemover = itemDoCarrinho;
                                    break;
                                }
                            }
                            if (produtoParaRemover == null) {
                                System.out.println("Produto não encontrado no carrinho.");
                                break;
                            }
                            carrinho.removerProduto(nomeRemover);
                            for (Produto item : produtos) {
                                if (item.getNome().equalsIgnoreCase(nomeRemover)) {
                                    item.setQuantidade(item.getQuantidade() + produtoParaRemover.getQuantidade());
                                    break;
                                }
                            }
                            System.out.println("Produto removido do carrinho com sucesso!");
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 7:
                    carrinho.finalizarCompra();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
