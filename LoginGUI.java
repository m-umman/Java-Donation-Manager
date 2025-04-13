import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class LoginGUI extends JFrame{
    private JTextField emailField,passwordField;
    private JComboBox<String> roleField;
    private JButton submitButton,backButton;

    public LoginGUI (ArrayList<Donor> donors , ArrayList<Organization> organizations,ArrayList<Donations> donation){
        setTitle("Login");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);



// Email
JLabel emailLabel = new JLabel("Enter email");
emailLabel.setBounds(50, 50, 100, 25);  // Adjusted for better spacing
add(emailLabel);

emailField = new JTextField();
emailField.setBounds(160, 50, 180, 25);  // Adjusted width and y-coordinate
add(emailField);

// Password
JLabel passwordLabel = new JLabel("Enter password");
passwordLabel.setBounds(50, 90, 120, 25);  // Adjusted spacing
add(passwordLabel);

passwordField = new JTextField();
passwordField.setBounds(160, 90, 180, 25);  // Adjusted width
add(passwordField);

// Dropdown (Role Selection)
JLabel roleLabel = new JLabel("Select role");
roleLabel.setBounds(50, 130, 120, 25);  // Adjusted for better alignment
add(roleLabel);

String[] role = {"Donor", "Organization"};
roleField = new JComboBox<>(role);
roleField.setBounds(160, 130, 180, 25);  // Adjusted width
add(roleField);

// Submit Button
submitButton = new JButton("Submit");
submitButton.setBounds(120, 180, 120, 30);  // Centered button
add(submitButton);

// Back Button
backButton = new JButton("Back");
backButton.setBounds(120, 230, 120, 30);  // Adjusted position
add(backButton);

// Submit Button Logic
submitButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String role = (String) roleField.getSelectedItem();
        if (role.equals("Donor")){
        String email = emailField.getText();
        String password = passwordField.getText();

        String result = "" ; 
        //keeping record of donor who login
        Donor d = null;
        //checking is it's data is available in my arraylist
        for (int i = 0 ; i < donors.size() ; i++){
         result = donors.get(i).login(email,password) ; 
         if (result.equals("Already")){
            d = donors.get(i); 
            break ;
         }else if (result.equals("Login Successfully")){
            d = donors.get(i); 
            break ;
         }
       
            
        }
        if(result.equals("")){
            JOptionPane.showMessageDialog(null, "Wrong Email or Password" );
        }else if (result.equals("Already")) {
            JOptionPane.showMessageDialog(null, "Already Login" );
            setVisible(false);
            dispose(); 
            new DonorGUI(d.getName(), d,donors ,organizations,donation);
            
        }
        else {
            JOptionPane.showMessageDialog(null, result );
            setVisible(false);
            dispose(); 
            new DonorGUI(d.getName(), d,donors ,organizations,donation);

        }


        
           
    }else {

        String email = emailField.getText();
        String password = passwordField.getText();

        String result = "" ; 
        //keeping record of login organization
        Organization org = null ;

        //checking is it's data is available in my arraylist
        for (int i = 0 ; i < organizations.size() ; i++){
         result = (organizations.get(i)).login(email,password) ; 
         if (result.equals("Already")){
            org = organizations.get(i);
            break ;
         }else if (result.equals("Login Successfully")){
            org = organizations.get(i);
            break ;
         }
        
            
        }
        if (result.equals("")){
            JOptionPane.showMessageDialog(null, "Wrong Email or Password" );
        }else if (result.equals("Already")) {
            JOptionPane.showMessageDialog(null, "Already Login" );
            setVisible(false);
            dispose(); 
            new OrganizationGUI(org.getName(),org,donors,organizations,donation);
            
        }
        else {
            JOptionPane.showMessageDialog(null, result );
            setVisible(false);
            dispose(); 
            new OrganizationGUI(org.getName(),org,donors,organizations,donation);

        }
        
    }
}
});
// Back Button Logic
backButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new HomeGUI(donors, organizations , donation);  

    }
});

        setVisible(true);
    }

}

