public class Review {
    private int id ;
    private static int count  = 0 ; 
    private String review ; 
    private Donor donor ;
    private Organization organization ; 
    private Campaign camp ;


 

    public Review (String review , Organization organization , Donor d ){
        this.review = review ;
        this.donor = d ;
        this.organization = organization ; 
        this.camp = null ;
        id = ++count ;
    }
    public Review (String review , Campaign camp , Donor d){
        this.review = review ; 
        this.camp = camp ; 
        this.organization = null ;
        this.donor = d ;
        id = ++count ;
    }

    public void setReview(String review){
        this.review = review ; 
    }

    public int getId (){
        return id ;
    }

    public void addDonor(Donor d){
        this.donor = d ;
    }

    public String getReview (){
        return review ;
    }
    public Donor getDonor (){
        return donor ;
    }
   

 

    @Override
    public String toString (){
        return review ;
       
    }
}
