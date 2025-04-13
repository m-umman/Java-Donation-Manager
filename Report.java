import java.util.ArrayList;

public class Report{
    private int id ;
    private static int count  = 0 ; 
    private String name ;
    private ArrayList<Donations> donations = new ArrayList<Donations>();

    public Report(){
        this("N/A");
    }
    public Report (String name){
        this.name = name  ; 
        id = ++count ;

    }

    public void setName(String name){
        this.name = name ;
    }
    public String getName(){
        return name ; 
    }

    public String donationsreport(ArrayList<Donations> d , String duration){
        String report = "";
        if (duration.equals("Monthly")){
                
               int date = Integer.parseInt(d.get(d.size()-1).getDate());
               int  year = date / 10000;
                int monthly_date = (date / 100) % 100; 
             
               
               //string to store report
               report += year + ": \n" + monthly_date + ":" ;
               int count = 1 ;

               for (int i = (d.size() -1) ; i >= 0  ; i--){
                 date = Integer.parseInt(d.get(i).getDate());
            

                 
                if ((date / 10000) == year){
                    if (((date /100) % 100) == monthly_date){
                        report +="\n" + count + " - " + d.get(i).getAmount() + " Amount Donated " ;
                        count++;
                        //savig refernce in arraylist
                        donations.add(d.get(i));
                    }else {
                        monthly_date -= 1 ;
                        //moving string to next line for previus month record 
                        report += "\n" + monthly_date + " :";
                        //keeping i same so that again we get same arraylis element to run if condition and store it in report string
                        i++;
                        count = 1 ; 
                    }
                }else {
                    break ;
                }
               }
               
            }
            else if (duration.equals("Yearly")) {
                int date = Integer.parseInt(d.get(d.size()-1).getDate());
                int  year = date / 10000;

                 report += year + " : ";

                int count = 1 ;

                for (int i = (d.size()-1) ; i >= 0 ; i--){
                    date = Integer.parseInt(d.get(i).getDate());
                    if ((date / 10000 ) == year){
                        report +="\n" + count + " - " + d.get(i).getAmount() + " Amount Donated " ;
                        count++;
                        //savig refernce in arraylist
                        donations.add(d.get(i));
                    }else {
                        break ; 
                    }
                }

            }else{
                int date = Integer.parseInt(d.get(d.size()-1).getDate());
                int  year = date / 10000;
                int last_year = year -1 ; 

                report += last_year + " : ";

                int count = 1 ;

                for (int i = (d.size()-1) ; i >= 0 ; i--){
                    date = Integer.parseInt(d.get(i).getDate());
                    if ((date /10000) == last_year && (date /10000) < year ){
                        report +="\n" + count + " - " + d.get(i).getAmount() + " Amount Donated " ;
                        count++;
                        //savig refernce in arraylist
                        donations.add(d.get(i));
                    }else if ((date /10000) > year) {
                        break ; 
                    }
                }


            }
            return report ;
    }

    @Override
    public String toString(){
        return name ;
    }

}
