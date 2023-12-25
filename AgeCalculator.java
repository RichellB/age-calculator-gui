// GUI Program that calculates's user's age based on entered date of birth

import java.time.LocalDate;
import java.time.Period;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

public class AgeCalculator extends JFrame implements ActionListener {

    private JLabel dobLabel; // Label for DOB
    private JLabel ageLabel; // Label for age
    private JTextField dobField; // Displays DOB
    private JTextField ageField; // Displays calculated age

    // Constructor that creates GUI components
    AgeCalculator() {

        // Defining frame's title
        setTitle("Age Calculator");

        // Creating new labels for date of birth and age fields
        dobLabel = new JLabel("Date of Birth (yyyy-mm-dd):");
        ageLabel = new JLabel("Your Age Is:");

        // Setting DOB and age fields
        dobField = new JTextField(15);
        dobField.setEditable(true);
        dobField.setText("0");

        ageField = new JTextField(15);
        ageField.setEditable(false);

        // Creating a "Calculate" button
        JButton calculateButton = new JButton("Calculate Age");

        // Using "this" to handle event listener (when calculate button is pressed)
        calculateButton.addActionListener(this);

        // This defines the GUI layout - GridBag
        GridBagConstraints layoutConst = null;

        // Using a GridBagLayout
        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();

        // Setting component's grid location
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;

        // Adding 10px padding around component
        layoutConst.insets = new Insets(30, 30, 30, 30);

        // Adding component layout using the below constraints
        add(dobLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(20, 20, 20, 20);
        add(dobField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(20, 20, 20, 20);
        add(ageLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(20, 20, 20, 20);
        add(ageField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(20, 20, 20, 20);
        add(calculateButton, layoutConst);
    }

    // This gets called when 'Calculate' button is pressed
    @Override
    public void actionPerformed(ActionEvent event) {

        // User's DOB
        String userInput;

        // Variable to store current date
        LocalDate currentDate = LocalDate.now();

        // Accepting user's DOB input from dobField
        userInput = dobField.getText();

        // Converting the dob input from String to a localDate type
        LocalDate dob = LocalDate.parse(userInput);

        /*
         * Using Period and getYears() functions to calculate the years between value in
         * dob and the current date
         */
        int years = Period.between(dob, currentDate).getYears();

        // Displaying the calculated age
        ageField.setText(Integer.toString(years));

    }

    // Creating a AgeCalculatorFrame
    public static void main(String[] args) {

        AgeCalculator myFrame = new AgeCalculator();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}