import java.util.ArrayList;

public class PermanentCampaign extends Campaign {
    private String startDate;
    private int id;
	private static int count=0;
    // Constructor
    public  PermanentCampaign(){
    	this("N/A","N/A",0,0,"N/A");
    }

    public PermanentCampaign(String name, String category, double goalAmount, double raiseAmount, String startDate) {
        super(name, category, goalAmount, raiseAmount);
         this.id=count++;  
        this.startDate = startDate;
    }
     public int getId() {
        return this.id;
    }


    //showing own donation list
    public String show_donation(){
        ArrayList<Donations> donation = super.getDonationArrayList();
        String list = "";
        int count = 0 ; 
        for (Donations d : donation){
           list += ++count + ": " + d.toString() + "\n" ; 
        }
        return list ; 
    }
    //showing own review list 
    public String show_review(){
        ArrayList<Review> reviews = super.getReviewArrayList();
        String list = "";
        int count = 0 ; 
        for (Review r : reviews){
           list += ++count + ": "+ r.toString() + "\n" ; 
        }
        return list ; 
    }

    
    @Override
    public void addDonation(Donations d){
        super.setDonations(d);
    }
    @Override
    public void addReview(Review r){
        super.setReview(r);
    }
    @Override
    public void addOrganization(Organization org){
        super.setOrganization(org);
    }



    // Getter method for start date
    public String getStartDate() {
        return this.startDate;
    }
  @Override
    public String toString(){
        return super.toString()+" Campaign Id: "+id+"\nCampaign Start Date"+startDate;
    }
}
