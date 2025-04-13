import java.util.ArrayList;

public abstract class Campaign{
	private String name;
	private String category;
	private double goalAmount;
	private double raiseAmount;
	private Organization organization ;
	private ArrayList<Donations> donation = new ArrayList<Donations>();
    private ArrayList<Review> reviews = new ArrayList<Review>();

	public Campaign(){
		this("N/A","N/A",0,0);
	}
	public Campaign(String name,String category,double goalAmount,double raiseAmount){
		this.name=name;
		this.category=category;
		this.goalAmount=goalAmount;
		this.raiseAmount=raiseAmount;
	}
	// setters
	public void setName(String name){
		this.name=name;
	}
	public void setOrganization(Organization organization){
		this.organization = organization ;
	}
	public void setReview(Review r){
		this.reviews.add(r);
	}
	public void setDonations(Donations donations){
		this.donation.add(donations);
	}
	public void setCategory(String category){
		this.category=category;
	}
	public void setGoalAmount(double goalAmount){
		this.goalAmount=goalAmount;
	}
	public void setRaiseAmount(double raiseAmount){
		this.raiseAmount=raiseAmount;
	}
	// getters
	public String getName(){
		return this.name;
	}
	public String getCategory(){
		return this.category;
	}
	public double getGoalAmount(){
		return this.goalAmount;
	}
	public double getRaiseAmount(){
		return this.raiseAmount;
	}
	public ArrayList<Donations> getDonationArrayList(){
		return donation ; 
	}
	public ArrayList<Review> getReviewArrayList(){
		return reviews ;
	}

	public abstract void addDonation(Donations d);
    public abstract void addReview(Review r);
	public abstract void addOrganization(Organization org);
@Override
public String toString(){
	return "Name:"+name+"\ncategory: "+category+"\nGoal Amount: "+goalAmount+"\nRaised Amount: "+raiseAmount;
}

}