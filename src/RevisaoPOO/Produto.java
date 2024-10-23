package RevisaoPOO;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto() {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void getNome() {
        System.out.println(this.nome);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void getPreco(){
        System.out.println(this.preco);
    }

    public void setQuantidadeEstoque(int qtd) {
        this.quantidadeEstoque = qtd;
    }

    public void getQuantidadeEstoque() {
        System.out.println(this.quantidadeEstoque);
    }

    public void aplicarDesconto(double porcentagem) {
        double desconto = (porcentagem/100) * this.preco;
        this.preco -= desconto;

    }
}
