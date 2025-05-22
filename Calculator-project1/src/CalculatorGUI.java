import MathOperations.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class CalculatorGUI extends JFrame {

    private JTextField inputField;
    private JLabel resultLabel;

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        inputField = new JTextField(25);
        JButton calculateBtn = new JButton("Calculate");
        resultLabel = new JLabel("Result: ");

        add(new JLabel("Enter your calculation:"));
        add(inputField);
        add(calculateBtn);
        add(resultLabel);

        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().replaceAll("\\s", "").toLowerCase();
                BigInteger result = BigInteger.ZERO;

                try {
                    if (input.equals("exit") || input.equals("q")) {
                        System.exit(0);
                    } else if (input.contains("!")) {
                        int n = Integer.parseInt(input.replace("!", ""));
                        result = new Factorial().fact(n);
                    } else {
                        String[] parts = input.split("(?<=[-+*/])|(?=[-+*/])");

                        if (parts.length != 3) {
                            resultLabel.setText("Invalid input format");
                            return;
                        }

                        BigInteger a = new BigInteger(parts[0]);
                        String operator = parts[1];
                        BigInteger b = new BigInteger(parts[2]);

                        switch (operator) {
                            case "+":
                                result = new Addition().add(a, b);
                                break;
                            case "-":
                                result = new Subtraction().subtract(a, b);
                                break;
                            case "*":
                                result = new Multiply().multiply(a, b);
                                break;
                            case "/":
                                if (b.equals(BigInteger.ZERO)) {
                                    resultLabel.setText("Division by zero not allowed");
                                    return;
                                }
                                result = new Divide().divide(a, b);
                                break;
                            default:
                                resultLabel.setText("Unknown operator");
                                return;
                        }
                    }

                    resultLabel.setText("Result: " + result);

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid number input");
                } catch (Exception ex) {
                    resultLabel.setText("Error: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
