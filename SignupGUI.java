
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class SignupGUI extends JFrame {
    private JTextField nameField, emailField,phoneField , passwordField;
    private JComboBox<String> roleField;
    private JButton submitButton;
    public SignupGUI (ArrayList<Donor> donors , ArrayList<Organization> organizations , ArrayList<Donations> donations){
        setTitle("SignUp");
setSize(400, 320);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);

// Name
JLabel nameLabel = new JLabel("Enter name:");
nameLabel.setBounds(30, 20, 100, 25);
add(nameLabel);

nameField = new JTextField();
nameField.setBounds(140, 20, 180, 25);
add(nameField);

// Phone number
JLabel phoneLabel = new JLabel("Enter phone:");
phoneLabel.setBounds(30, 60, 100, 25);
add(phoneLabel);

phoneField = new JTextField();
phoneField.setBounds(140, 60, 180, 25);
add(phoneField);

// Email
JLabel emailLabel = new JLabel("Enter email:");
emailLabel.setBounds(30, 100, 100, 25);
add(emailLabel);

emailField = new JTextField();
emailField.setBounds(140, 100, 180, 25);
add(emailField);

// Password
JLabel passwordLabel = new JLabel("Enter password:");
passwordLabel.setBounds(30, 140, 120, 25);
add(passwordLabel);

passwordField = new JTextField();
passwordField.setBounds(140, 140, 180, 25);
add(passwordField);

// Dropdown for Role
JLabel roleLabel = new JLabel("Select role:");
roleLabel.setBounds(30, 180, 100, 25);
add(roleLabel);

String[] role = {"Donor", "Organization"};
roleField = new JComboBox<>(role);
roleField.setBounds(140, 180, 180, 25);
add(roleField);

// Submit Button
submitButton = new JButton("Submit");
submitButton.setBounds(140, 220, 100, 30);
add(submitButton);

submitButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String role = (String) roleField.getSelectedItem();
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (role.equals("Donor")) {
            Donor donor = new Donor(name, phone, email, password);
            donors.add(donor);
        } else {
            Organization org = new Organization(name, phone, email, password);
            organizations.add(org);
        }

        JOptionPane.showMessageDialog(null, "You signed up successfully with\nEmail: " + email);
        setVisible(false);
        new HomeGUI(donors, organizations,donations);
    }
});

// Back Button
JButton backButton = new JButton("Back");
backButton.setBounds(30, 220, 80, 30);
add(backButton);

backButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); 
        dispose(); 
        new HomeGUI(donors, organizations,donations); 
        

    }
});

        setVisible(true);
    }
}
