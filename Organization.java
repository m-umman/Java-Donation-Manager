import java.util.ArrayList;

public class Organization extends User{
    private int id ; 
    private static int count = 0 ;
    private boolean login_status = false ; 
    private ArrayList<Donations> donation = new ArrayList<Donations>();
    private ArrayList<Review> reviews = new ArrayList<Review>();
    protected static ArrayList<Campaign> camp = new ArrayList<Campaign>();


    public Organization () {
       this("N/A","N/A","N/A","N/A");
     }
     
    public Organization (String name , String phone_number ,String email , String password) {
         super(name,phone_number,email,password); 
         this.id = ++count ; 
    } 

    //setter
    public void setName(String name){
        super.setName(name);
    }

     //getter
     public String getName(){
        return super.getName();
    }

    @Override
    public String login (String email , String password){
        String result = "";
         
        if (this.getEmail().equals(email) && this.getPassword().equals(password)){
            if(login_status == false){
            login_status = true ;
            result += "Login Successfully"; 
        }else {
            result += "Already";
            
        }
    }else {
        result = "";
    }
    return result ;
    }

    public String logout(){
        String logout = "";
        if (login_status){
            login_status = false ; 
            logout = "Logout Successfully"; 
        }else {
            logout = "Already Logout";
        }
        return logout ; 
    }

    public void madeCampaign(String name , String category , double goal , double raise , String startDate , String endDate){
        TemporaryCampaign temporaryCampaign = new TemporaryCampaign(name ,category ,goal ,raise ,startDate ,endDate);
        camp.add(temporaryCampaign);

    }
    public void madeCampaign(String name , String category , double goal , double raise , String startDate){
        PermanentCampaign permanentCampaign = new PermanentCampaign(name ,category ,goal ,raise ,startDate);
        camp.add(permanentCampaign);

    }

    public void addDonation(Donations d){
        this.donation.add(d);
    }
    public void addReview(Review r){
        this.reviews.add(r);
    }

    //showing own donations list 
    public String show_donation(){
        String list = "";
        int count = 0 ; 
        for (Donations d : donation){
           list += ++count + ": " + d.toString() + "\n"  ; 
        }
        return list ; 
    }

     //showing own review list 
     public String show_review(){
        String list = "";
        int count = 0 ; 
        for (Review r : reviews){
           list += ++count + ": " + r.toString() + " given by " + r.getDonor().getName() + "\n" ; 
        }
        return list ; 
    }

    //showing campaign donations list 
    public String show_camp_donation(){
        String list = "";
        int count = 0 ; 
        for (Campaign c : camp){
            if (c instanceof TemporaryCampaign){
            TemporaryCampaign temp = (TemporaryCampaign) c ; 
            list += ++count + ": " + temp.getName()+ "\n";
           list += temp.show_donation() + "\n" ; 
            }else {
                PermanentCampaign per = (PermanentCampaign) c ; 
                list += ++count + ": " + per.getName()+ "\n";
           list += per.show_donation() + "\n" ; 
            }
        }
        return list ; 
    }

     //showing campaign review list 
     public String show_camp_review(){
        String list = "";
        int count = 0 ; 
        for (Campaign c : camp){
        if (c instanceof TemporaryCampaign){
            TemporaryCampaign temp = (TemporaryCampaign) c ; 
            list += ++count + ": " + temp.getName()+ "\n";
            list += temp.show_review() + "\n" ; 
        }else {
            PermanentCampaign per = (PermanentCampaign) c ;
            list += ++count + ": " + per.getName()+ "\n";
            list += per.show_review() + "\n" ;
        }
        
    }
    return list ; 
}

    @Override
    public String toString (){
        return "ID : " + this.id + " " + super.toString();
    }

}