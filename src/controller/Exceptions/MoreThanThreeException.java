package controller.Exceptions;

public class MoreThanThreeException extends  Exception {
    public MoreThanThreeException(String errorMsg){
        super(errorMsg);
    }
}
