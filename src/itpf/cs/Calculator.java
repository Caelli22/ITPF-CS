/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itpf.cs;

/**
 *
 * @author Ryven
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField numberField;
    private double number1, number2, result;
    private int operator;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);

        numberField = new JTextField();
        numberField.setEditable(false);
        numberField.setPreferredSize(new Dimension(75, 75));
        add(numberField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            buttonPanel.add(button);
            button.setFont(new Font("Serif", Font.PLAIN, 50));
        }
        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(this);
        buttonPanel.add(zeroButton);
        zeroButton.setFont(new Font("Serif", Font.PLAIN, 50));

        JButton decimalButton = new JButton(".");
        decimalButton.addActionListener(this);
        buttonPanel.add(decimalButton);
        decimalButton.setFont(new Font("Serif", Font.PLAIN, 50));

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        clearButton.setFont(new Font("Serif", Font.PLAIN, 50));

        // Create the operator buttons
        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
        addButton.setFont(new Font("Serif", Font.PLAIN, 50));
        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton);
        subtractButton.setFont(new Font("Serif", Font.PLAIN, 50));
        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton);
        multiplyButton.setFont(new Font("Serif", Font.PLAIN, 50));
        JButton divideButton = new JButton("/");
        divideButton.addActionListener(this);
        buttonPanel.add(divideButton);
        divideButton.setFont(new Font("Serif", Font.PLAIN, 50));

        add(buttonPanel, BorderLayout.CENTER);

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        add(equalsButton, BorderLayout.SOUTH);
        equalsButton.setPreferredSize(new Dimension(75, 75));
        equalsButton.setFont(new Font("Serif", Font.PLAIN, 50));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton)e.getSource()).getText();
        if (buttonText.matches("[0-9]")) {
            numberField.setFont(new Font("Serif", Font.PLAIN, 50));
            numberField.setText(numberField.getText() + buttonText);
        } else if (buttonText.equals(".")) {
            if (!numberField.getText().contains(".")) {
                numberField.setFont(new Font("Serif", Font.PLAIN, 50));
                numberField.setText(numberField.getText() + ".");
            }
        } else if (buttonText.equals("+")) {
            number1 = Double.parseDouble(numberField.getText());
            operator = 1;
            numberField.setText("");
        } else if (buttonText.equals("-")) {
            number1 = Double.parseDouble(numberField.getText());
            operator = 2;
            numberField.setText("");
        } else if (buttonText.equals("*")) {
            number1 = Double.parseDouble(numberField.getText());
            operator = 3;
            numberField.setText("");
        } else if (buttonText.equals("/")) {
            number1 = Double.parseDouble(numberField.getText());
            operator = 4;
            numberField.setText("");
        } else if (buttonText.equals("C")) {
            number1 = Double.parseDouble(numberField.getText());
            numberField.setText("");
        }
        else if (buttonText.equals("=")) {
            number2 = Double.parseDouble(numberField.getText());
            switch(operator) {
                case 1:
                    result = number1 + number2;
                    break;
                case 2:
                    result = number1 - number2;
                    break;
                case 3:
                    result = number1 * number2;
                    break;
                case 4:
                    result = number1 / number2;
                    break;
            }
            numberField.setText(Double.toString(result));
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}