package lab1.factory.exceptions;

public class DuplicateModelNameException extends Exception {

    public DuplicateModelNameException() {
        super("Model name duplicated");
    }

}
