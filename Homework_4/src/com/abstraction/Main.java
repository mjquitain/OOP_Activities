package com.abstraction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Daily Sales Calculator");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel phoneLabel = new JLabel("Phone Details");
        phoneLabel.setBounds(10, 20, 150, 25);
        panel.add(phoneLabel);

        JLabel phonePriceLabel = new JLabel("Price:");
        phonePriceLabel.setBounds(10, 50, 80, 25);
        panel.add(phonePriceLabel);

        JTextField phonePriceText = new JTextField(20);
        phonePriceText.setBounds(100, 50, 165, 25);
        panel.add(phonePriceText);

        JLabel phoneQuantityLabel = new JLabel("Quantity Sold:");
        phoneQuantityLabel.setBounds(10, 80, 80, 25);
        panel.add(phoneQuantityLabel);

        JTextField phoneQuantityText = new JTextField(20);
        phoneQuantityText.setBounds(100, 80, 165, 25);
        panel.add(phoneQuantityText);

        JLabel repairLabel = new JLabel("Repair Service Details");
        repairLabel.setBounds(10, 120, 150, 25);
        panel.add(repairLabel);

        JLabel repairPriceLabel = new JLabel("Price per Hour:");
        repairPriceLabel.setBounds(10, 150, 100, 25);
        panel.add(repairPriceLabel);

        JTextField repairPriceText = new JTextField(20);
        repairPriceText.setBounds(120, 150, 145, 25);
        panel.add(repairPriceText);

        JLabel repairHoursLabel = new JLabel("Number of Hours:");
        repairHoursLabel.setBounds(10, 180, 100, 25);
        panel.add(repairHoursLabel);

        JTextField repairHoursText = new JTextField(20);
        repairHoursText.setBounds(120, 180, 145, 25);
        panel.add(repairHoursText);

        JButton calculateButton = new JButton("Calculate Sales");
        calculateButton.setBounds(10, 220, 150, 25);
        panel.add(calculateButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 250, 300, 50);
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double phonePrice = Double.parseDouble(phonePriceText.getText());
                int phoneQuantity = Integer.parseInt(phoneQuantityText.getText());
                double repairPrice = Double.parseDouble(repairPriceText.getText());
                int repairHours = Integer.parseInt(repairHoursText.getText());

                Phone phone = new Phone("Phone", phonePrice, phoneQuantity);
                RepairService repairService = new RepairService("Repair", repairPrice, repairHours);

                double totalPhoneSales = phone.calculateTotalSales();
                double totalRepairSales = repairService.calculateTotalSales();

                resultLabel.setText("<html>Total Phone Sales: ₱" + totalPhoneSales + 
                                   "<br>Total Repair Sales: ₱" + totalRepairSales + "</html>");
            }
        });
    }
}