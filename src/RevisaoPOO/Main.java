package RevisaoPOO;

public class Main {
    public static void main(String[] args) {
        Produto Arroz = new Produto();
        Arroz.setNome("Arroz");
        Arroz.getNome();
        Arroz.setPreco(30.00);
        Arroz.getPreco();
        Arroz.setQuantidadeEstoque(200);
        Arroz.aplicarDesconto(10);
        Arroz.getPreco();
    }
}
