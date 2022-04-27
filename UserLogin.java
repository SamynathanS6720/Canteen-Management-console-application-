package foodcanteen;

import java.util.Scanner;
import foodcanteen.AddDetails;
import foodcanteen.OperationNotFound;

public class UserLogin{
    boolean flag ;
    String uname ; 
    String pword ;
    OperationNotFound ex ;
    AddDetails fl  = new AddDetails();
    Scanner read = new Scanner(System.in);
    public void log()    
    {   
        System.out.println("Enter \n 1. Login \n 2. SignIn");
        switch( read.nextLine())   
        {   case "1":
                do{
                    flag = false ;
                    try{
                        System.out.println("Enter User Name ");
                        uname = System.console().readLine();

                        if( !AddDetails.userList.containsKey(uname) ){
                            ex = new OperationNotFound("\n User Name not Exist . Enter Correct User Name ");
                            flag = true ; 
                            throw ex ;
                        }

                        System.out.println("Enter Password :");
                        pword = System.console().readLine();

                        if( !AddDetails.userList.get(uname).password.equals(pword)){
                            ex = new OperationNotFound("\n Wrong Password ");
                            flag = true ; 
                            throw ex ;
                        }

                        System.out.println("\nEnter Option\n 1. Order Food \n 2. View Balance \n 3. Exit ");
                        switch( read.nextLine() ){
                            case "1":
                                fl.viewAvailableFoodsList();

                                break;
                            case "2":
                                
                                System.out.println( "\nCredits : " + AddDetails.userList.get(uname).freeCreadits);
                                System.out.println( "\nMain Balance : " + AddDetails.userList.get(uname).mainBalance );
                                System.out.println( "\nTotal Balance : " +( AddDetails.userList.get(uname).freeCreadits + AddDetails.userList.get(uname).mainBalance ) );
                                System.out.println( "\n Days " + AddDetails.userList.get(uname).day );
                                fl.viewTrans( uname );
                                break;
                            case "3":
                                flag = false ;
                                break ;
                            default :
                                ex = new OperationNotFound("\nEnter the Correct option in the list ");
                                throw ex ;
                        }
                    }
                    catch(OperationNotFound e){
                        System.out.println("\n" + e + "\n");
                    }
                    System.out.println("\nEnter 0 to Exit or click Enter to Continue");
                    if( System.console().readLine().equals("0") ){
                            flag = false ;
                            break ;
                    }
                    
                }while(flag);
                break;
            case "2" :
                usersign();
                break;
            default:
                System.out.println("Enter correct Option");
        }
    }

    public void usersign(){
         do{
            flag = false ;
            try{
                System.out.println("Enter User Name ");
                uname = System.console().readLine();

                if( AddDetails.userList.containsKey(uname) ){
                    ex = new OperationNotFound("\n User Name Already Exist. Enter Any other User Name ");
                    flag = true ; 
                    throw ex ;
                }

                System.out.println("Enter Password :");
                pword = System.console().readLine();

                fl.addUser( uname , pword , 0 );
                fl.addtran( uname , "Free Credit" , "+300" );

            }
            catch(OperationNotFound e){
                System.out.println("\n" + e + "\n");
            }
            System.out.println("\nEnter 0 to Exit or click Enter to Continue");
            if( System.console().readLine().equals("0") ){
                    flag = false ;
            }
            
        }while(flag);
    }
}