package foodcanteen;

public class Admin{
    private final String adminId = "admin";
    private String adminPassword = "admin";

    public boolean passwordvalidation( String pw ){
        if( adminPassword.equals(pw)){
            return false ;
        }
        else{
            return true ;
        }
    }
}