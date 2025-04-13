public abstract class User{
    private String name ;
    private String phone_number ; 
    private String email ; 
    private String password ; 

    public User (String name , String phone_number ,String email , String password ) {
        this.name = name ;
        this.phone_number = phone_number ; 
        this.email = email ; 
        this.password = password ; 
    }
    //setters 
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    //getters
    public String getName(){
        return name ;
    }
    public String getPhoneNumber(){
        return name ;
    }
    public String getEmail(){
        return email ; 
    }
    public String getPassword(){
        return password ; 
    }

    public abstract String login(String email, String password);
    public abstract String logout();

    @Override
    public String toString (){
        return "\nName : " + this.name + "\nPhone Number : " + this.phone_number + "\nEmail : "+ this.email + "\nPassword : " + this.password ; 
    }


}