import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class OrganizationGUI extends JFrame {
    private JTextField nameField, categoryField, goalField,raiseField,startDateField,endDateField;
    private JButton submitButton, campButton , tempButton , perButton , backButton,camp_reviewButton,camp_donationsButton,reviewButton,donationsButton,logoutButton;
    private JLabel nameLabel, categoryLabel, goalLabel,raiseLabel,startDateLabel,endDateLabel , actionLabel , campLabel;
    private JComboBox <String> orgField ;
    private String selection = "" ; 
    private String selection_camp_temp_per = "" ;

    public OrganizationGUI(String name , Organization org , ArrayList<Donor> donor ,ArrayList<Organization> organization , ArrayList<Donations> donation){
        setTitle(name);
        setSize(700, 700);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);

// Label for select action 
actionLabel = new JLabel("Select Action: ");
actionLabel.setBounds(10, 20, 120, 30);
add(actionLabel);

// Campaign Button
campButton = new JButton("Build Campaign");
campButton.setBounds(140, 20, 150, 30);
add(campButton);

// Show donations list received
donationsButton = new JButton("Own Donations");
donationsButton.setBounds(310, 20, 150, 30);
add(donationsButton);

// Show review list received
reviewButton = new JButton("Own Reviews");
reviewButton.setBounds(480, 20, 150, 30);
add(reviewButton);

// Show donations received in campaign
camp_donationsButton = new JButton("Campaign Donations");
camp_donationsButton.setBounds(140, 60, 150, 30);
add(camp_donationsButton);

// Show campaign reviews
camp_reviewButton = new JButton("Campaign Review");
camp_reviewButton.setBounds(310, 60, 150, 30);
add(camp_reviewButton);

// Event Actions
//campaign selection button
campButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        show_campaign();
        selection = "camp";
    }
});

//showing organization own donation list
donationsButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String list1 = org.getName() + " :\n" + org.show_donation() ;
        JOptionPane.showMessageDialog(null,list1 );
    }
});

//showing organization own reiew list 
reviewButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String list2 = org.getName() + " :\n" + org.show_review() ;
        JOptionPane.showMessageDialog(null, list2);
    }
    
});

//
camp_donationsButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String list3 = org.getName() + " :\n" + org.show_camp_donation();
        JOptionPane.showMessageDialog(null, list3);
    }
});
//
camp_reviewButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String list4 = org.getName() + " :\n" + org.show_camp_review();
        JOptionPane.showMessageDialog(null, list4);
    }
});

// Name
nameLabel = new JLabel("Name: ");
nameLabel.setBounds(20, 110, 100, 30);
add(nameLabel);

nameField = new JTextField();
nameField.setBounds(140, 110, 200, 30);
add(nameField);

// Category
categoryLabel = new JLabel("Category: ");
categoryLabel.setBounds(20, 150, 100, 30);
add(categoryLabel);

categoryField = new JTextField();
categoryField.setBounds(140, 150, 200, 30);
add(categoryField);

// Goal Amount
goalLabel = new JLabel("Goal Amount: ");
goalLabel.setBounds(20, 190, 120, 30);
add(goalLabel);

goalField = new JTextField();
goalField.setBounds(140, 190, 200, 30);
add(goalField);

// Raised Amount
raiseLabel = new JLabel("Raised Amount: ");
raiseLabel.setBounds(20, 230, 120, 30);
add(raiseLabel);

raiseField = new JTextField();
raiseField.setBounds(140, 230, 200, 30);
add(raiseField);

// Temporary and Permanent Buttons
tempButton = new JButton("Temporary");
tempButton.setBounds(80, 270, 120, 30);
add(tempButton);

perButton = new JButton("Permanent");
perButton.setBounds(210, 270, 120, 30);
add(perButton);

tempButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        show_temp_fields();
        selection_camp_temp_per = "temp";
    }
});

perButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        show_per_fields();
        selection_camp_temp_per = "per";
    }
});

// Start Date
startDateLabel = new JLabel("Start Date: ");
startDateLabel.setBounds(20, 310, 120, 30);
add(startDateLabel);

startDateField = new JTextField();
startDateField.setBounds(140, 310, 200, 30);
add(startDateField);

// End Date
endDateLabel = new JLabel("End Date: ");
endDateLabel.setBounds(20, 350, 120, 30);
add(endDateLabel);

endDateField = new JTextField();
endDateField.setBounds(140, 350, 200, 30);
add(endDateField);

// Submit Button
submitButton = new JButton("Submit");
submitButton.setBounds(100, 400, 120, 40);
add(submitButton);

// Back Button
backButton = new JButton("Back");
backButton.setBounds(230, 400, 120, 40);
add(backButton);

// logot Button
logoutButton = new JButton("Logout");
logoutButton.setBounds(360, 400, 120, 40);
add(logoutButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             if (selection_camp_temp_per.equals("temp")){
               String name = nameField.getText();
               String category = categoryField.getText();
               double goal =    Double.parseDouble(goalField.getText());
               double raise = Double.parseDouble(raiseField.getText());
                String startDate = startDateField.getText();
                String endDate = endDateField.getText();
                org.madeCampaign(name ,category ,goal ,raise ,startDate ,endDate);
                JOptionPane.showMessageDialog(null,"\nSuccessfully! You made Temporary Campaign with name " + name);
             }else{
                String name = nameField.getText();
                String category = categoryField.getText();
                double goal = Double.parseDouble(goalField.getText());
                double raise = Double.parseDouble(raiseField.getText());
                 String startDate = startDateField.getText();
                 org.madeCampaign(name ,category ,goal ,raise ,startDate);
                 JOptionPane.showMessageDialog(null,"\nSuccessfully! You made Permanent Campaign with name " + name);
             } 
        }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomeGUI(donor,organization,donation);
        }
             
        });

       // logout button action
logoutButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String result = org.logout();
        JOptionPane.showMessageDialog(null, result);
        setVisible(false);
        new HomeGUI(donor,organization,donation);
    }
});


        hid();
        setVisible(true);
    }

    public void hid(){
        nameField.setVisible(false);
        nameLabel.setVisible(false);
        categoryField.setVisible(false);
        categoryLabel.setVisible(false);
        goalField.setVisible(false);
        goalLabel.setVisible(false);
        raiseField.setVisible(false);
        raiseLabel.setVisible(false);
        startDateField.setVisible(false);
        startDateLabel.setVisible(false);
        endDateField.setVisible(false);
        endDateLabel.setVisible(false);
        tempButton.setVisible(false);
        perButton.setVisible(false);

    }
    public void show_per_fields(){
        startDateField.setVisible(true);
        startDateLabel.setVisible(true);
        endDateField.setVisible(true);
        endDateLabel.setVisible(true);
        //hiding end date 
        endDateField.setVisible(false);
        endDateLabel.setVisible(false);
    }
    public void show_temp_fields(){
        startDateField.setVisible(true);
        startDateLabel.setVisible(true);
        endDateField.setVisible(true);
        endDateLabel.setVisible(true);
        

    }
    public void show_campaign(){
        nameField.setVisible(true);
        nameLabel.setVisible(true);
        categoryField.setVisible(true);
        categoryLabel.setVisible(true);
        goalField.setVisible(true);
        goalLabel.setVisible(true);
        raiseField.setVisible(true);
        raiseLabel.setVisible(true);
        tempButton.setVisible(true);
        perButton.setVisible(true);
    }

}
