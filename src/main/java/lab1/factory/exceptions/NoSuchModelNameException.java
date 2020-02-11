package lab1.factory.exceptions;

public class NoSuchModelNameException extends Exception {

    public NoSuchModelNameException() {
        super("There is no such name in array");
    }

}
