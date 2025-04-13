import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

class HomeGUI extends JFrame {
    private JButton Signup;
    private JButton Login;
    private JButton show_donors,show_org,show_donation;

    public HomeGUI(ArrayList<Donor> donors , ArrayList<Organization> organizations ,ArrayList<Donations> donation ){
        setTitle("Home Page");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


         // Signup Button
        Signup = new JButton("SignUp");
        Signup.setBounds(100, 140, 100, 30);  // Adjusted y-coordinate
        add(Signup);

         // login Button
        Login = new JButton("Login");
        Login.setBounds(100, 180, 100, 30);  // Adjusted y-coordinate
        add(Login);

         // show donors Button
         show_donors = new JButton("Donors");
         show_donors.setBounds(100, 220, 100, 30);  // Adjusted y-coordinate
         add(show_donors);

         // show organization Button
         show_org = new JButton("Organization");
         show_org.setBounds(100, 260, 100, 30);  // Adjusted y-coordinate
         add(show_org);

           // show donations Button
           show_donation = new JButton("Donations");
           show_donation.setBounds(100, 300, 100, 30);  // Adjusted y-coordinate
           add(show_donation);


          Signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
              if (e.getSource() == Signup){
                setVisible(false);
                dispose(); 
             new SignupGUI(donors , organizations , donation);
            }
            }
        });


        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
              if (e.getSource() == Login){
                setVisible(false);
                dispose(); 
               new LoginGUI(donors , organizations , donation);
            }
            }
        });

        show_donors.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
           String list = "";
           int count = 1 ;
           for (Donor donor : donors){
            list += "ID "+count +":\n "+ donor.toString() + "\n";
            count++;
           }
           JOptionPane.showMessageDialog(null, list);
          }
      });

      show_org.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         String list = "";
         for (Organization org : organizations){
          list += org.toString() + "\n";
         }
         JOptionPane.showMessageDialog(null, list);
        }
    });

    show_donation.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
       String list = "";
       int count = 1; 
       for (Donations d : donation){
        list += count+": " + d.toString() + "\n";
        count++;
       }
       JOptionPane.showMessageDialog(null, list);
      }
  });

        setVisible(true);
    }
}


public class Test {
  
    public static void main(String[] args) {
        // Admin admin = new Admin("umman", "3744", "ummann5723@gmail.com", "123");
        ArrayList<Donor> donors = new ArrayList<Donor>();
        ArrayList<Organization> organizations = new ArrayList<>();
        ArrayList<Donations> donation = new ArrayList<>();

        new HomeGUI(donors,organizations,donation);

     
    }
    
}
