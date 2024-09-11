import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String numNotasStr = JOptionPane.showInputDialog("Digite o número de notas que deseja inserir:");
        int numNotas = Integer.parseInt(numNotasStr);

        double[] notas = inserirNotas(numNotas);

        PrintarNotas(notas);

        double media = calcularMedia(notas);
        JOptionPane.showMessageDialog(null, "Média das notas: " + media);
    }

    public static double[] inserirNotas(int numNotas) {
        double[] notas = new double[numNotas];

        for (int i = 0; i < numNotas; i++) {
            String notaStr = JOptionPane.showInputDialog("Digite a nota " + (i + 1) + ": ");
            notas[i] = Double.parseDouble(notaStr);
        }

        return notas;
    }

    public static void PrintarNotas(double[] notas) {
        StringBuilder notasStr = new StringBuilder("Notas inseridas:\n");
        for (int i = 0; i < notas.length; i++) {
            notasStr.append("Nota ").append(i + 1).append(": ").append(notas[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, notasStr.toString());
    }

    public static double calcularMedia(double[] notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
}
