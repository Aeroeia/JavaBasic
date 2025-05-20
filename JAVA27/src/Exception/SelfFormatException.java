package Exception;

public class SelfFormatException extends RuntimeException {
    public  SelfFormatException(){
        super();
    }
    public  SelfFormatException(String message){
        super(message);
    }
}
