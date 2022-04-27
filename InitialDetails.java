package foodcanteen;

import foodcanteen.AddDetails;


public class InitialDetails{
        public AddDetails initial = new AddDetails();

    public InitialDetails(){
        
        initial.addFood( "Dosa" , 5 , 30 , -1 );
        initial.addFood( "Idli" , 15 , 10 , -1 );
        initial.addFood( "Masala Dosa" , 3 , 50 , 1 );
        initial.addFood( "Vada" , 10 , 10 , 2);
        initial.addFood( "Pongal" , 8 , 25 , -1 );
    }
}