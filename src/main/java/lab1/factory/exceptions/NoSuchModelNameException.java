package lab1.factory.exceptions;

public class NoSuchModelNameException extends Exception {

    public NoSuchModelNameException(String name) {
        super("There is no such name in array: " + name);
    }

}
