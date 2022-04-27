package foodcanteen;

import foodcanteen.AddDetails;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GetFoodDetails{
    public void setFoodDet( String foodname){
        AddDetails additem = new AddDetails() ;
        // String foodname ;
        int availcount;
        int prise ;
        char maxlimit;
        int count = 0;
        boolean flag ;
        // OperationNotFound ex;
        Scanner read = new Scanner(System.in);
        do{
            flag = false ;
            try{
                
                System.out.println("\n Enter Avlilablity" );
                 availcount = read.nextInt();  

                System.out.println("\n Enter Cost of the food");
                 prise = read.nextInt();

                System.out.println("\n Set the User Limintation of food count Enter U for unlimited ");
                maxlimit = read.next().charAt(0);
                if( maxlimit == 'U'){
                    count = -1 ;
                }
                else{
                    try{
                        count = (int) maxlimit ;
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
                additem.addFood( foodname , availcount , prise ,count);
            }
            catch(InputMismatchException er){
                System.out.println("\nEnter Valide Data\n");
                System.out.println("Enter 0 to Exit");
                if( System.console().readLine() == "0" ){
                    flag = false ;
                    break ;
                }
                flag = true ;
                read.nextLine();
            }
        }while(flag);
    }
}