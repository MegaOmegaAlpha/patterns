package lab1.factory.exceptions;

public class DuplicateModelNameException extends Exception {

    public DuplicateModelNameException(String name) {
        super("Model name duplicated: " + name);
    }

}
