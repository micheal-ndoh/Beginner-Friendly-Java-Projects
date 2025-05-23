package com.temp;
import java.awt.*;
import javax.swing.*;

public class TemperatureConverterGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 180);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));

        JLabel valueLabel = new JLabel("Value:");
        JTextField valueField = new JTextField();

        JLabel fromLabel = new JLabel("From:");
        String[] units = {"C", "F", "K"};
        JComboBox<String> fromBox = new JComboBox<>(units);

        JLabel toLabel = new JLabel("To:");
        JComboBox<String> toBox = new JComboBox<>(units);

        JButton convertBtn = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result: ");

        panel.add(valueLabel); panel.add(valueField);
        panel.add(fromLabel); panel.add(fromBox);
        panel.add(toLabel); panel.add(toBox);
        panel.add(new JLabel()); panel.add(convertBtn);
        panel.add(new JLabel()); panel.add(resultLabel);

        convertBtn.addActionListener(e -> {
            try {
                double value = Double.parseDouble(valueField.getText());
                char from = fromBox.getSelectedItem().toString().charAt(0);
                char to = toBox.getSelectedItem().toString().charAt(0);
                double result = Main.convert(value, from, to);
                resultLabel.setText("Result: " + String.format("%.2f", result) + to);
            } catch (Exception ex) {
                resultLabel.setText("Invalid input!");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}