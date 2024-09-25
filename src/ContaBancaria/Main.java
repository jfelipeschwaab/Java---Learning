package ContaBancaria;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ContaBancaria minhaConta = new ContaBancaria();
        String[] options = {
                "1. Ver Titular",
                "2. Mudar o nome do Titular",
                "3. Ver número da Conta",
                "4. Mudar número da Conta",
                "5. Ver saldo",
                "6. Depositar",
                "7. Sacar",
                "8. Sair do App MyBank"
        };

        int opcao = 0;
        while (opcao != 8) {
            String input = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha uma opção:",
                    "App MyBank",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            opcao = Integer.parseInt(input.substring(0, 1));

            switch (opcao) {
                case 1:
                    if (minhaConta.getTitular().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Você precisa colocar o nome do titular nesta conta.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Titular: " + minhaConta.getTitular());
                    }
                    break;

                case 2:
                    String novoTitular = JOptionPane.showInputDialog("Digite o novo nome do Titular:");
                    minhaConta.setTitular(novoTitular);
                    JOptionPane.showMessageDialog(null, "Nome do titular alterado com sucesso.");
                    break;

                case 3:
                    if (minhaConta.getNumeroConta() == 0) {
                        JOptionPane.showMessageDialog(null, "Você precisa definir o número da conta (5 dígitos).");
                    } else {
                        JOptionPane.showMessageDialog(null, "Número da Conta: " + minhaConta.getNumeroConta());
                    }
                    break;

                case 4:
                    String novoNumeroConta = JOptionPane.showInputDialog("Digite o novo número da conta (5 dígitos):");
                    minhaConta.setNumeroConta(novoNumeroConta);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saldo: " + minhaConta.getSaldo());
                    break;

                case 6:
                    String valorDeposito = JOptionPane.showInputDialog("Digite o valor a depositar:");
                    double deposito = Double.parseDouble(valorDeposito);
                    if (minhaConta.depositar(deposito)) {
                        JOptionPane.showMessageDialog(null, "Você acabou de depositar: R$ " + String.format("%.2f", deposito) + "\nSaldo atual: " + minhaConta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Você não pode depositar valores negativos.");
                    }
                    break;

                case 7:
                    String valorSaque = JOptionPane.showInputDialog("Digite o valor a sacar:");
                    double saque = Double.parseDouble(valorSaque);
                    if (minhaConta.sacar(saque)) {
                        JOptionPane.showMessageDialog(null, "Você acabou de sacar: R$ " + String.format("%.2f", saque) + "\nSaldo atual: " + minhaConta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar o saque.");
                    }
                    break;

                case 8:
                    JOptionPane.showMessageDialog(null, "Saindo do App MyBank. Até logo!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
