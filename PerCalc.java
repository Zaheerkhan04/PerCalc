package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PercentageCalculator extends JFrame {
    
    // GUI Components
    private JTextField value1Field;
    private JTextField value2Field;
    private JTextField resultField;
    private JComboBox<String> operationBox;

    public PercentageCalculator() {
        // Frame setup
        setTitle("Percentage Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Create components
        JLabel value1Label = new JLabel("Value 1:");
        value1Label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        value1Label.setBounds(10, 20, 100, 30);

        value1Field = new JTextField(10);
        value1Field.setForeground(new Color(255, 255, 255));
        value1Field.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        value1Field.setBounds(120, 20, 123, 30);
        value1Field.setBackground(new Color(0, 128, 128));

        JLabel value2Label = new JLabel("Value 2:");
        value2Label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        value2Label.setBounds(10, 60, 100, 49);

        value2Field = new JTextField(10);
        value2Field.setForeground(new Color(255, 255, 255));
        value2Field.setBackground(new Color(0, 128, 128));
        value2Field.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        value2Field.setBounds(120, 60, 123, 30);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        resultLabel.setBounds(10, 140, 100, 38);

        resultField = new JTextField(10);
        resultField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resultField.setBounds(120, 140, 136, 30);
        resultField.setEditable(false);
        resultField.setBackground(new Color(255, 249, 196));

        JLabel operationLabel = new JLabel("Operation:");
        operationLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        operationLabel.setBounds(10, 100, 100, 25);

        String[] operations = { "Calculate Percentage", "Percentage Increase", "Percentage Decrease", "Find Whole" };
        operationBox = new JComboBox<>(operations);
        operationBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        operationBox.setBounds(120, 100, 174, 38);
        operationBox.setBackground(new Color(179, 179, 217));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        calculateButton.setBounds(120, 180, 136, 30);
        calculateButton.setBackground(new Color(179, 179, 217));
        calculateButton.setForeground(Color.WHITE);

        // Add listeners
        calculateButton.addActionListener(new CalculateButtonListener());

        // Add components to frame
        getContentPane().add(value1Label);
        getContentPane().add(value1Field);
        getContentPane().add(value2Label);
        getContentPane().add(value2Field);
        getContentPane().add(operationLabel);
        getContentPane().add(operationBox);
        getContentPane().add(resultLabel);
        getContentPane().add(resultField);
        getContentPane().add(calculateButton);
    }

    // Inner class for button click handling
    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double value1 = Double.parseDouble(value1Field.getText());
                double value2 = Double.parseDouble(value2Field.getText());
                String operation = (String) operationBox.getSelectedItem();
                double result = 0;

                switch (operation) {
                    case "Calculate Percentage":
                        result = calculatePercentage(value1, value2);
                        break;
                    case "Percentage Increase":
                        result = calculatePercentageIncrease(value1, value2);
                        break;
                    case "Percentage Decrease":
                        result = calculatePercentageDecrease(value1, value2);
                        break;
                    case "Find Whole":
                        result = findWhole(value1, value2);
                        break;
                }

                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
            }
        }
    }

    // Methods for calculations
    private double calculatePercentage(double part, double whole) {
        return (part / whole) * 100;
    }

    private double calculatePercentageIncrease(double original, double increase) {
        return ((increase / original) * 100);
    }

    private double calculatePercentageDecrease(double original, double decrease) {
        return ((decrease / original) * 100);
    }

    private double findWhole(double part, double percentage) {
        return (part / percentage) * 100;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PercentageCalculator().setVisible(true);
            }
        });
    }
}
