package foodcanteen;

import foodcanteen.FoodList;
import foodcanteen.User;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class AddDetails{

    public static Map< String , FoodList > foodList = new LinkedHashMap < String , FoodList > ();
    public static Map< String , User > userList = new LinkedHashMap < String , User > ();
    // public static ArrayList < Bill > billlist = new ArrayList < Bill > () ;
    
    public void addUser( String name , String pword , int balance ){
        User newuser = new User () ;
        newuser.password = pword;
        newuser.freeCreadits = 300;
        newuser.mainBalance = balance ;
        userList.put( name , newuser);
    }

    public void addFood( String iName , int availCount , int itPrise , int max_per_user ){
        FoodList fl = new FoodList ();
        fl.availableCount = availCount;
        fl.itemPrice = itPrise ;
        fl.max_units_per_user = max_per_user ;
        foodList.put( iName , fl);
    }

    public void viewfoodDetails( FoodList item ){
        System.out.print(" \t\t\t" + item.availableCount + "\t\t\t" + item.itemPrice );
        if( item.max_units_per_user == -1 )
            System.out.print( "\t\t\t Unlimited"  ); 
        else 
            System.out.print("\t\t\t   " + item.max_units_per_user);
    }

    public void viewAvailableFoodsList(){
        Set < String > flist = foodList.keySet();
        System.out.println("\nItem \t\t Available Count \t\t Price \t\t Max units per User");
        for ( String key : flist ){
            System.out.println( "\n" + key ) ;
            viewfoodDetails( foodList.get(key));
        }
    }

    public void addtran( String name, String desc , String amount  ){
        ArrayList < String > trans = new ArrayList < String > ();
        trans.add(desc);
        trans.add( "Day "+String.valueOf(AddDetails.userList.get(name).day));
        trans.add( ( amount) );
        trans.add( String.valueOf( AddDetails.userList.get(name).mainBalance +  AddDetails.userList.get(name).freeCreadits ) );
        AddDetails.userList.get(name).transections.add(trans);
    }

    public void viewTrans( String name ){
        System.out.println( "\nDec \t\t\t Date \t\t Debit/Credit \t\t Balance\n");
        for( int i = 0 ; i < AddDetails.userList.get(name).transections.size() - 1 ; i++ )
        {   
            for( int j = 0 ; j < 4 ; j++)
                System.out.print( AddDetails.userList.get(name).transections.get(i).get(j) + "\t\t");
            System.out.println("\n" );
        }   
         
    }


}