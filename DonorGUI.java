
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class DonorGUI extends JFrame{
    private JTextField amountField, reviewField,dateField;
    private JButton submitButton, backButton,reviewButton, donationButton;
    private JButton organizationButton, campaignButton,otherButton,logoutButton; 
    private JLabel amountLabel, reviewLabel, receiverLabel,actionLabel,campLabel,orgLabel,dateLabel;
    private JComboBox <Organization> orgField ;
    private JComboBox <Campaign> campField;
    private String selection_donation_review = "" ; 
    private String selection_organization_campaign = "" ; 

    public DonorGUI (String name , Donor d ,ArrayList<Donor> donor ,ArrayList<Organization> organization,ArrayList<Donations> donations_list ){
        setTitle(name);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Label for Select Action
actionLabel = new JLabel("Select Action : ");
actionLabel.setBounds(20, 30, 120, 25); // Improved positioning
add(actionLabel);

// Donation Button
donationButton = new JButton("Donation");
donationButton.setBounds(150, 30, 110, 30); // Adjusted width and spacing
add(donationButton);

// Review Button
reviewButton = new JButton("Review");
reviewButton.setBounds(280, 30, 110, 30);
add(reviewButton);

// Other Button
otherButton = new JButton("Other");
otherButton.setBounds(410, 30, 110, 30);
add(otherButton);

// Button event actions
donationButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        show_donation();
        selection_donation_review = "donation";
    }
});

reviewButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        show_review();
        selection_donation_review = "review";  
    }
});

otherButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Other(name, d, donor ,organization , donations_list); 
    }
});

// Amount
amountLabel = new JLabel("Enter Amount");
amountLabel.setBounds(20, 80, 120, 25);
add(amountLabel);

amountField = new JTextField();
amountField.setBounds(150, 80, 160, 25);
add(amountField);

// Date
dateLabel = new JLabel("Enter Date (YYYYMMDD)");
dateLabel.setBounds(10, 120, 170, 25);
add(dateLabel);

dateField = new JTextField();
dateField.setBounds(200, 120, 160, 25);
add(dateField);

// Review
reviewLabel = new JLabel("Enter Review");
reviewLabel.setBounds(20, 160, 120, 25);
add(reviewLabel);

reviewField = new JTextField();
reviewField.setBounds(150, 160, 160, 25);
add(reviewField);

// Label for Receiver
receiverLabel = new JLabel("Receiver : ");
receiverLabel.setBounds(20, 200, 100, 25);
add(receiverLabel);

// Organization Button
organizationButton = new JButton("Organization");
organizationButton.setBounds(140, 200, 140, 30);
add(organizationButton);

// Campaign Button
campaignButton = new JButton("Campaign");
campaignButton.setBounds(290, 200, 130, 30);
add(campaignButton);

// Button event actions
organizationButton.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        show_organization();
        selection_organization_campaign = "organization";
    }
});

campaignButton.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        show_campaign();
        selection_organization_campaign = "campaign"; 
    }
});

// Dropdown of Organization
orgLabel = new JLabel("Select Organization");
orgLabel.setBounds(20, 250, 150, 25);  
add(orgLabel);

orgField = new JComboBox<>();
orgField.setBounds(180, 250, 480, 25); 
add(orgField);

for (Organization org : organization) {
    orgField.addItem(org);
}

// Dropdown of Campaign
campLabel = new JLabel("Select Campaign");
campLabel.setBounds(20, 290, 150, 25);  
add(campLabel);

campField = new JComboBox<>();
campField.setBounds(180, 290, 480, 25);  
add(campField);

for (Campaign c : Organization.camp) {
    campField.addItem(c);
}

// Submit Button
submitButton = new JButton("Submit");
submitButton.setBounds(100, 350, 120, 35);
add(submitButton);

// Back Button
backButton = new JButton("Back");
backButton.setBounds(250, 350, 120, 35);
add(backButton);

// logot Button
logoutButton = new JButton("Logout");
logoutButton.setBounds(400, 350, 120, 35);
add(logoutButton);

// Submit button action
submitButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (selection_donation_review.equals("donation")) {
            if (selection_organization_campaign.equals("organization")) {
                double amount = Double.parseDouble(amountField.getText());
                String date = dateField.getText();
                Organization org = (Organization) orgField.getSelectedItem();
                Donations donation = new Donations (amount,date,org);
                //calling donor method to add donation 
                d.makeDonation(donation);
                //calling organization method to add donation 
                org.addDonation(donation);
                //calling donation method to add refernce of donor , organization or campaign 
                donation.addDonor_org(d,org);
                //storing donation object in arraylist to keep record 
                donations_list.add(donation);
                JOptionPane.showMessageDialog(null, "Donated Successfully to " + org.getName() + " Organization");
            } else {
                double amount = Double.parseDouble(amountField.getText());
                String date = dateField.getText();
                Campaign camp = (Campaign) campField.getSelectedItem();
                Donations donation = new Donations (amount,date,camp);
                //calling donor method to add donation 
                d.makeDonation(donation);
                //calling organization method to add donation 
                camp.addDonation(donation);
                //calling donation method to add refernce of donor , organization or campaign 
                donation.addDonor_camp(d,camp);
                //storing donation object in arraylist to keep record 
                donations_list.add(donation);
                JOptionPane.showMessageDialog(null, "Donated Successfully to " + camp.getName() + " Campaign");
            }
        } else {
            if (selection_organization_campaign.equals("organization")) {
                String review = reviewField.getText();
                Organization org = (Organization) orgField.getSelectedItem();
                d.writeReveiw(review, org);
                JOptionPane.showMessageDialog(null, "Review Submitted Successfully");
            } else {
                String review = reviewField.getText();
                Campaign camp = (Campaign) campField.getSelectedItem();
                d.writeReveiw(review, camp);
                JOptionPane.showMessageDialog(null, "Review Submitted Successfully");
            }
        }
    }
});

// Back button action
backButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new HomeGUI(donor, organization,donations_list);
    }
});

// logout button action
logoutButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String result = d.logout();
        JOptionPane.showMessageDialog(null, result);
        setVisible(false);
        new HomeGUI(donor, organization,donations_list);
    }
});


        



        hid();
        setVisible(true);
    }

    public void hid(){
        amountField.setVisible(false);
        amountLabel.setVisible(false);
        reviewLabel.setVisible(false);
        reviewField.setVisible(false);
        receiverLabel.setVisible(false);
        organizationButton.setVisible(false);
        campaignButton.setVisible(false);
        orgLabel.setVisible(false);
        orgField.setVisible(false);
        campLabel.setVisible(false);
        campField.setVisible(false);
        dateLabel.setVisible(false);
        dateField.setVisible(false);

    }
    public void show_donation(){
        amountField.setVisible(true);
        amountLabel.setVisible(true);
        receiverLabel.setVisible(true);
        organizationButton.setVisible(true);
        campaignButton.setVisible(true);
        dateLabel.setVisible(true);
        dateField.setVisible(true);
        //hiding review 
        reviewLabel.setVisible(false);
        reviewField.setVisible(false);
    }
    public void show_review(){
        reviewLabel.setVisible(true);
        reviewField.setVisible(true);
        receiverLabel.setVisible(true);
        organizationButton.setVisible(true);
        campaignButton.setVisible(true);
        //hiding donation 
        amountField.setVisible(false);
        amountLabel.setVisible(false);
        dateLabel.setVisible(false);
        dateField.setVisible(false);

    }
    public void show_organization(){
        orgLabel.setVisible(true);
        orgField.setVisible(true);
        //hiding campaign 
        campLabel.setVisible(false);
        campField.setVisible(false);
       
    }
    public void show_campaign(){
        campLabel.setVisible(true);
        campField.setVisible(true);
        //hiding organization 
        orgLabel.setVisible(false);
        orgField.setVisible(false);
    }

  

}

