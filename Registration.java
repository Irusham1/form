import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Registration extends JFrame {

// Define the labels, text fields, password field, and button
private JLabel nameLabel, emailLabel, passwordLabel, dobLabel, phoneLabel;
private JTextField nameField, emailField, phoneField;
private JPasswordField passwordField;
private JFormattedTextField dobField;
private JButton submitButton;

public Registration() {
// Set up the main frame
setTitle("Creative Registration Form");
setSize(500, 450);
setLocationRelativeTo(null); // Center on screen
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
getContentPane().setBackground(new Color(240, 248, 255)); // Light background color

// Set custom fonts
Font labelFont = new Font("Arial", Font.BOLD, 14);
Font textFieldFont = new Font("Arial", Font.PLAIN, 14);

// Initialize components
nameLabel = new JLabel("Full Name:");
emailLabel = new JLabel("Email Address:");
passwordLabel = new JLabel("Password:");
dobLabel = new JLabel("Date of Birth (YYYY-MM-DD):");
phoneLabel = new JLabel("Phone Number:");

nameLabel.setFont(labelFont);
emailLabel.setFont(labelFont);
passwordLabel.setFont(labelFont);
dobLabel.setFont(labelFont);
phoneLabel.setFont(labelFont);

nameField = new JTextField(20);
emailField = new JTextField(20);
phoneField = new JTextField(20);
passwordField = new JPasswordField(20);
dobField = new JFormattedTextField(new java.text.SimpleDateFormat("yyyy-MM-dd"));
dobField.setColumns(20);

nameField.setFont(textFieldFont);
emailField.setFont(textFieldFont);
phoneField.setFont(textFieldFont);
passwordField.setFont(textFieldFont);
dobField.setFont(textFieldFont);

submitButton = new JButton("Submit");
submitButton.setFont(new Font("Arial", Font.BOLD, 14));
submitButton.setBackground(new Color(70, 130, 180)); // Steel blue button
submitButton.setForeground(Color.WHITE);
submitButton.setFocusPainted(false);
//submitButton.setBorder(BorderFactory.createRoundedBorder(20));

// Add custom border and background to the form container
JPanel panel = new JPanel();
panel.setLayout(new GridLayout(6, 2, 10, 10)); // 6 rows, 2 columns for all fields
panel.setBackground(new Color(255, 255, 255)); // white background for form
panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margin

// Add components to the panel
panel.add(nameLabel);
panel.add(nameField);
panel.add(emailLabel);
panel.add(emailField);
panel.add(phoneLabel);
panel.add(phoneField);
panel.add(passwordLabel);
panel.add(passwordField);
panel.add(dobLabel);
panel.add(dobField);
panel.add(new JLabel()); // Empty space
panel.add(submitButton);

add(panel);

// Action listener for the submit button
submitButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String name = nameField.getText();
String email = emailField.getText();
String phone = phoneField.getText();
String password = new String(passwordField.getPassword());
String dobText = dobField.getText();

// Validate the input fields
if (name.isEmpty() || email.isEmpty() || password.isEmpty() || dobText.isEmpty() || phone.isEmpty()) {
JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
return;
}

if (!validation.isValidEmail(email)) {
JOptionPane.showMessageDialog(null, "Invalid email format!", "Error", JOptionPane.ERROR_MESSAGE);
return;
}

if (!validation.isValidPhoneNumber(phone)) {
JOptionPane.showMessageDialog(null, "Phone number should be 10 digits!", "Error", JOptionPane.ERROR_MESSAGE);
return;
}

if (!validation.isValidDob(dobText)) {
JOptionPane.showMessageDialog(null, "Invalid Date of Birth format. Please use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
return;
}

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate dob = LocalDate.parse(dobText, formatter);

User user = new User(name, email, phone, password, dob);
boolean success = database.insertUser(user);


if (success) {
JOptionPane.showMessageDialog(null, "Registration Successful!");
} else {
JOptionPane.showMessageDialog(null, "Error in registration. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
}
}
});

}
}