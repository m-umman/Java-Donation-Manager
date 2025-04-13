public class Donations {
    private int id ;
    private static int count  = 0 ; 
    private double amount ;
    private String date ; 
    private Donor donor ;
    private Organization organization ; 
    private Campaign camp ;


    public Donations(){
        this(0, "N/A", (Organization) null); 
    }
    

    public Donations (double amount , String date , Organization organization ){
        this.amount = amount ;
        this.date = date ; 
        this.organization = organization ; 
        this.camp = null ;
        id = ++count ;
    }
    public Donations (double amount , String date , Campaign camp){
        this.amount = amount ;
        this.date = date ; 
        this.camp = camp ; 
        this.organization = null ;
        id = ++count ;
    }

    public void setAmount (double amount){
        this.amount = amount ; 
    }
    public void setDonor(Donor d){
        this.donor = d ; 
    }

    public void setDate(){
        this.date = date ; 
    }

    public int getId (){
        return id ;
    }

    public double getAmount (){
        return amount ;
    }
    public String getDate(){
        return date ; 

    }

    public void addDonor_org(Donor d , Organization org){
        this.donor = d ;
        this.organization = org ; 
    }
    public void addDonor_camp(Donor d,Campaign c){
        this.donor = d;
        this.camp = c;
    }



    @Override
    public String toString(){
        if (camp != null){
            if(donor != null){
        return amount + " dollars Donated by " + donor.getName() + " at " + date + " date " + " to campaign " + camp.getName();
            }else{
                return amount + " dollars Donated by unknown donor at " + date + " date " + " to campaign " + camp.getName();
            }
        }else{
            if(donor != null){
            return amount + "dollars Donated by " + donor.getName() + " at " + date + " date " + " to organization " + organization.getName() ;
            }else{
                return amount + " dollars Donated by unknown donor at " + date + " date " + " to campaign " + organization.getName() ;
            }
        }
    }
    
}
