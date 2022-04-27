
import foodcanteen.InitialDetails;
import foodcanteen.AdminLogin;
import java.util.Scanner;
import java.util.Set;
import foodcanteen.Admin;
import foodcanteen.AddDetails;
import foodcanteen.UserLogin;

public class HomePage{
    public static void main( String[] args ){
        Scanner read = new Scanner(System.in);
        AdminLogin nobj = new AdminLogin();
        Admin admin = new Admin (); 
        UserLogin ulog = new UserLogin();
        boolean flag ;
        String name ;
        AddDetails add = new AddDetails();
        add.addUser( "akash" , "password" , 0);
        add.addUser( "vignesh" , "Admin@123", 0);

        Outer :
        do{

             Set < String > userlist = AddDetails.userList.keySet();
                for ( String key : userlist ){
                    if ( AddDetails.userList.get(key).day % 3 == 1 ){
                        AddDetails.userList.get(key).freeCreadits = 300 ;  
                        add.addtran( key , "Free Credit" , String.valueOf( "+300") );
                    }
                    // System.out.println( "===========" + ( AddDetails.userList.get(key).day % 3 )  );
                    
                }

            System.out.println("\n Canteen Closed \n");
            flag = true ;
        
                System.out.println("\nEnter Password to open");
                name = read.nextLine();

                if( admin.passwordvalidation(name) ){
                   System.out.println("\nWrong Password");
                    continue Outer;
                }
                else{
                    InitialDetails obj = new InitialDetails();

                    while(true){
                        System.out.println("\n 1. Admin \n 2. User \n 3. Close ");
                        switch(System.console().readLine()){
                            case "1":
                                nobj.adminLogin();
                                break;
                            case "2":
                                ulog.log();
                                break;
                            case "3":
                                System.out.println("\nEnter Password to close");
                                name = System.console().readLine();

                                if( admin.passwordvalidation(name) ){
                                    System.out.println("\nWrong Password");
                                    name = "" ;
                                    continue ;
                                }
                                Set < String > ulist = AddDetails.userList.keySet();
                                for ( String key : ulist ){
                                    if ( AddDetails.userList.get(key).day % 3 == 0 ){
                                        String temp = String.valueOf ( AddDetails.userList.get(key).freeCreadits );
                                        AddDetails.userList.get(key).freeCreadits = 0 ;
                                        add.addtran( key , "Credit Reset" , String.valueOf( "-"+temp) );
                                          
                                    }
                                    AddDetails.userList.get(key).day = AddDetails.userList.get(key).day + 1 ;
                                }
                                
                                continue Outer;
                            default:
                                System.out.println("\n Enter Correct Operation");
                                break;
                        }
                    }

                }
        }while(flag);
    }
}