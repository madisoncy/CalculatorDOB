package calculatorDOB;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;

public class AgeDOBCalc {

	public static void main(String[] args) {
		 JFrame frame = new JFrame("Age Calculator");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(900, 250);
	        frame.setLayout(new FlowLayout());

	        JPanel panel = new JPanel();
	        JLabel label = new JLabel("Please enter your date of birth in YYYY-MM-DD format:");
	        JTextField birthDateField = new JTextField(10);
	        JButton calculateButton = new JButton("Calculate Age");
	        JLabel ageLabel = new JLabel();

	        calculateButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    LocalDate birthDate = LocalDate.parse(birthDateField.getText());
	                    LocalDate now = LocalDate.now();
	                    Period period = Period.between(birthDate, now);
	                    ageLabel.setText("Your age is: " + period.getYears());
	                } catch (Exception ex) {
	                    ageLabel.setText("Invalid date! Please try again.");
	                }
	            }
	        });

	        panel.add(label);
	        panel.add(birthDateField);
	        panel.add(calculateButton);
	        panel.add(ageLabel);

	        frame.add(panel);
	        frame.setVisible(true);
	    }
	}