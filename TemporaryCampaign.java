import java.util.ArrayList;
public class TemporaryCampaign extends Campaign{
	private int id;
	private static int count=0;
    private String startDate;
    private String endDate;

     public  TemporaryCampaign(){
    	this("N/A","N/A",0,0,"N/A","N/A");
    }
	 public TemporaryCampaign(String name, String category, double goalAmount, double raiseAmount, String startDate, String endDate) {
        super(name, category, goalAmount, raiseAmount);
        this.id=++count; 
        this.startDate = startDate;
        this.endDate = endDate;

    }
	public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
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
	
	
    @Override
    public String toString(){
        return super.toString()+" Campaign Id: "+id+"\nCampaign Start Date"+startDate+"\nCampaign End Date: "+endDate;
    }
  
}