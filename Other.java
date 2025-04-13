
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class Other extends JFrame{
    private JButton reportButton , submitButton,delButton;
    private JTextField reportField1 ;
    private JLabel reportLabel ,reportLabel1, actionLabel ;
    private JComboBox <String> reportField ;
    private String selection_report = "" ;
   

    public Other (String name , Donor d ,ArrayList<Donor> donor ,ArrayList<Organization> organization , ArrayList<Donations> donations ){
        setTitle(name);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        
        // Label for action selection
actionLabel = new JLabel("Select Action:");
actionLabel.setBounds(20, 30, 120, 25);  
add(actionLabel);

// Report Button
reportButton = new JButton("Report");
reportButton.setBounds(150, 30, 120, 30);  
add(reportButton);

// delete Account button
delButton = new JButton("Delete Account");
delButton.setBounds(250, 30, 150, 30);  
add(delButton);

reportButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        selection_report = "report";
        show_report_fields();
    }
});

delButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        d.deleteAccount();
        //removing donor from arraylist
        donor.remove(d);
        setVisible(false);
        JOptionPane.showMessageDialog(null, "Account deleted successfully");
        new HomeGUI(donor, organization,donations);
    }
});

// Report Name Label
reportLabel1 = new JLabel("Name:");
reportLabel1.setBounds(20, 80, 120, 25);
add(reportLabel1);

// Report Name Text Field
reportField1 = new JTextField();
reportField1.setBounds(150, 80, 180, 25);
add(reportField1);

// Dropdown Label
reportLabel = new JLabel("Select Duration:");
reportLabel.setBounds(20, 120, 120, 25);
add(reportLabel);

// Dropdown for Duration
String[] duration = {"Monthly", "Yearly", "Last Year"};
reportField = new JComboBox<>(duration);
reportField.setBounds(150, 120, 180, 25);
add(reportField);

// Submit Button
submitButton = new JButton("Submit");
submitButton.setBounds(150, 170, 100, 30);
add(submitButton);

submitButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (selection_report.equals("report")) {
            String name = reportField1.getText();
            String duration = (String) reportField.getSelectedItem();
            String result = d.generateReport(name, duration);
            JOptionPane.showMessageDialog(null, result);
        }
    }
});

// Back Button
JButton backButton = new JButton("Back");
backButton.setBounds(20, 170, 100, 30);
add(backButton);

backButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); 
        new DonorGUI(name ,d ,donor ,organization , donations);
    }
});


        hid();
        setVisible(true);
    }

    public void hid(){
        reportLabel1.setVisible(false);
        reportField1.setVisible(false);
        reportLabel.setVisible(false);
        reportField.setVisible(false);

    }
    public void show_report_fields(){
        reportLabel1.setVisible(true);
        reportField1.setVisible(true);
        reportLabel.setVisible(true);
        reportField.setVisible(true);
    }
   

}

