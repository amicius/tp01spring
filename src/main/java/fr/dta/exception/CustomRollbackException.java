package fr.dta.exception;

public class CustomRollbackException extends Exception{

    private static final long serialVersionUID = 1L;
    
    public CustomRollbackException(String message) {
        super(message);
    }
    

}
