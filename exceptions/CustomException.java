package exceptions;

public class CustomException  extends Exception{
    public CustomException(String message){
        super(message);
    }

    public static void main(String[] args) {
        try {
            throw new CustomException("Custom Exception occurred");
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
