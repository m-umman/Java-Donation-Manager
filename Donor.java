import java.util.ArrayList ; 
import java.util.Collections;
public class Donor extends  User {
    private int id ; 
    private static int count = 0 ;
    private boolean login_status = false ; 
    private ArrayList<Donations> donation = new ArrayList<Donations>();
    private ArrayList<Review> reviews = new ArrayList<Review>();
    private ArrayList<Report> report = new ArrayList<Report>();


    public Donor () {
        this("N/A","N/A","N/A","N/A");
    }

    public Donor (String name , String phone_number ,String email , String password ){
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
    public int getId(){
        return id ;
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

    @Override
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


    public void deleteAccount(){
        //for deleting account all donations that this donor made making unknown by setting donor refrence to null
        for (Donations d : donation){
            d.setDonor(null);
        }
        
    }

    public void makeDonation(Donations donations){
        // d.addDonor(this);
        donation.add(donations);
        // org.addDonation(donations);
    }
    // public void makeDonation(Campaign camp){
    //     // Donations d = new Donations (amount,date,camp);
    //     // d.addDonor(this);
    //     donation.add(camp);
    //     camp.addDonation(d);
        
    // }
    public void writeReveiw(String review , Organization org ){
        Review r = new Review (review,org,this);
        r.addDonor(this);
        reviews.add(r);
        org.addReview(r);
    }
    public void writeReveiw(String review , Campaign camp){
        Review r = new Review (review,camp,this);
        r.addDonor(this);
        reviews.add(r);
        camp.addReview(r);
    }
    public String generateReport(String name ,String duration){
        Report r = new Report(name);
        report.add(r);
        // sorting donation arraylist in ascending order
        for(int j = 0 ; j < donation.size() ; j++){
            for(int i = 0 ; i < donation.size() - 1 ; i++){
            if (donation.get(i).getDate().compareTo(donation.get(i + 1).getDate()) > 0) {
               Donations temp = donation.get(i);
            donation.set(i, donation.get(i + 1));
            donation.set(i + 1, temp);
            }
        }
        }
        String result = r.donationsreport(donation,duration);
        return result ; 

    }

    @Override
    public String toString (){
        return  super.toString();
    }
}
