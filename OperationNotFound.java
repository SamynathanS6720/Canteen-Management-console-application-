package foodcanteen;

import java.lang.Thread;

public class OperationNotFound extends Exception{
    public OperationNotFound( String msg ){
        super(msg);
    }
}