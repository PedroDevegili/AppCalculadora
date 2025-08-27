import javax.swing.*;
import java.awt.*;

public class AppCalc {

    public static int soma(int a, int b) {
        return a + b;
    }

    public static int subtracao(int a, int b) {
        return a - b;
    }
    
    public static int multiplicacao(int a, int b) {
        return a * b;
    }

    public static double divisao(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Divisão por zero não permitida!");
        return (double) a / b;
    }


    public static void main(String[] args) {
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 14));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 14));

        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField campoA = new JTextField();
        JTextField campoB = new JTextField();

        String[] operacoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        JComboBox<String> comboOperacao = new JComboBox<>(operacoes);

        painel.add(new JLabel("Digite o primeiro número:"));
        painel.add(campoA);

        painel.add(new JLabel("Digite o segundo número:"));
        painel.add(campoB);

        painel.add(new JLabel("Escolha a operação:"));
        painel.add(comboOperacao);

        JOptionPane.showMessageDialog(
            null,
            painel,
            "Calculadora",
            JOptionPane.PLAIN_MESSAGE
        );

        try {
            int a = Integer.parseInt(campoA.getText());
            int b = Integer.parseInt(campoB.getText());

            int resultado = 0;
            String operacao = (String) comboOperacao.getSelectedItem();

            if (operacao.equals("Soma")) {
                resultado = soma(a, b);
            } else if (operacao.equals("Subtração")) {
                resultado = subtracao(a, b);
            } else if (operacao.equals("Multiplicação")) {
                resultado = multiplicacao(a, b);
            } else if (operacao.equals("Divisão")) {
                resultado = (int) divisao(a, b);
            }

            JOptionPane.showMessageDialog(
                null,
                "Resultado da " + operacao.toLowerCase() + "É: " + resultado,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                null,
                "Coloque números válidos.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}