import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
public class Calculator implements ActionListener{
    private static JButton button;
    private static JLabel label;
    private double total = 0;
    private String currentNumber = "";
    private String lastOperator = "";

    public static void main(String[] args) {
        String icon = "";
        int x = 0;
        int y = 360;
        
        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel();

        frame.setSize(330, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null); 

        label = new JLabel();
        label.setBounds(0, 0, 316, 125);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        label.setBorder(border);
        panel.add(label);

        for(int i = 0; i < 4; i++) {
            x = 15;
            for(int j = 0; j < 4; j++){
                if(i == 0 && j == 0) icon = "C";
                if(i == 0 && j == 1) icon = "0";
                if(i == 0 && j == 2) icon = "=";
                if(i == 0 && j == 3) icon = "/";
                if(i == 1 && j == 0) icon = "1";
                if(i == 1 && j == 1) icon = "2";
                if(i == 1 && j == 2) icon = "3";
                if(i == 1 && j == 3) icon = "x";
                if(i == 2 && j == 0) icon = "4";
                if(i == 2 && j == 1) icon = "5";
                if(i == 2 && j == 2) icon = "6";
                if(i == 2 && j == 3) icon = "-";
                if(i == 3 && j == 0) icon = "7";
                if(i == 3 && j == 1) icon = "8";
                if(i == 3 && j == 2) icon = "9";
                if(i == 3 && j == 3) icon = "+";

                button = new JButton(icon);
                button.setForeground(null);
                button.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
                button.setBounds(x, y, 60, 60);
                button.addActionListener(new Calculator());
                panel.add(button);
                x += 75;
            }
            y -= 75;
        }
        frame.add(panel); 
        frame.setVisible(true); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0))) {
            currentNumber += command;
            System.out.println("Current Number: " + currentNumber);
        } else if (command.equals("C")) {
            total = 0;
            currentNumber = "";
            lastOperator = "";
            System.out.println("Cleared");
        } else if (command.equals("=")) {
            if (!currentNumber.isEmpty()) {
                calculate(Double.parseDouble(currentNumber));
                System.out.println("Total: " + total);
                currentNumber = "";
                lastOperator = "";
            } else {
                System.out.println("Error: No number to calculate");
            }
        } else {
            if (!currentNumber.isEmpty()) {
                calculate(Double.parseDouble(currentNumber));
                currentNumber = "";
            }
            lastOperator = command;
            System.out.println("Operator: " + lastOperator);
        }
    }

    private void calculate(double number) {
        switch (lastOperator) {
            case "+":
                total += number;
                break;
            case "-":
                total -= number;
                break;
            case "x":
                total *= number;
                break;
            case "/":
                if (number != 0) {
                    total /= number;
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                total = number;
        }
    }
}
