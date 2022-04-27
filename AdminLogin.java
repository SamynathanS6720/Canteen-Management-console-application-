package foodcanteen;

import java.util.Set;
import foodcanteen.Admin;
import foodcanteen.GetFoodDetails;
import foodcanteen.OperationNotFound;
import foodcanteen.AddDetails;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class AdminLogin{
    boolean flag ;
    String name;
    GetFoodDetails get = new GetFoodDetails();
    Admin admin = new Admin();
    OperationNotFound ex ;
    Scanner read = new Scanner(System.in);
    int amount ;
    AddDetails addDet = new AddDetails();
    public void adminLogin()
    {   
        do{
            flag = false ;
            try{

                System.out.println("\nSelect Option");
                System.out.println("\n 1. Add Food item \n 2. Alter Food detail \n 3. Delete Food item\n 4. Add Amount to User Account \n 5. Exit " );
                switch(System.console().readLine()){
                    case "1":
                        System.out.println("\n Enter Food Name ");
                        name = System.console().readLine();

                        if( AddDetails.foodList.containsKey( name) ){
                            ex = new OperationNotFound("\nFood Item Already Present in the list ");
                            flag = true ; 
                            throw ex ;
                        }

                        get.setFoodDet(name);
                        break ;
                    case "2":
                        System.out.println("\nEnter name of the food item to Alter");
                        Set < String > flist = AddDetails.foodList.keySet();
                        
                        for ( String key : flist ){
                            System.out.println( "\n" + key ) ;
                        }
                        System.out.println("\n Enter Food Name ");
                        name = System.console().readLine();

                        get.setFoodDet(name);
                        break ;
                    case "3":
                        System.out.println("\nEnter name of the food item to delete");
                        Set < String > foodlist = AddDetails.foodList.keySet();
                        
                        for ( String key : foodlist ){
                            System.out.println( "\n" + key ) ;
                        }
                        String deletename = System.console().readLine();
                        if( !AddDetails.foodList.containsKey( deletename) ){
                            ex = new OperationNotFound("\nEnter the Food Item Present in the list");
                            flag = true ; 
                            throw ex ;
                        }
                        AddDetails.foodList.remove(deletename);
                        break;
                    case "4":
                        System.out.println("\n Enter User Name ");
                        name = System.console().readLine();

                        if( !AddDetails.userList.containsKey( name ) ){
                            ex = new OperationNotFound("\nUser Name not found in the list ");
                            flag = true ; 
                            throw ex ;
                        }

                        System.out.println("Enter Amount ");
                        amount = read.nextInt();
                        AddDetails.userList.get(name).mainBalance = amount ;
                        addDet.addtran( name , "topup by admin" , ("+"+amount) );

                        break ;
                    case "5":
                        flag = false ;
                        break;
                    default :
                        ex = new OperationNotFound("\nEnter the Correct option in the list ");
                        throw ex ;        
                }        

            }
            catch(OperationNotFound e){
                System.out.println("\n" + e + "\n");
            }
            catch(InputMismatchException er){
                System.out.println("\nEnter Correct Option\n");
            }
            System.out.println("Enter 0 to Exit or click Enter to Continue ");
            if( System.console().readLine().equals("0") ){
                flag = false ;
                break ;
            }
        }while(flag);
    }

} 