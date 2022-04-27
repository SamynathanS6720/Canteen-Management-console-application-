package foodcanteen;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class User{
    public String password;
    public int freeCreadits = 0;
    public int mainBalance = 0 ;
    public int day = 1 ;
    public ArrayList < Integer > orderedTokens = new ArrayList < Integer > ();
    public ArrayList < ArrayList < String > > transections = new ArrayList < ArrayList < String > > ();

}