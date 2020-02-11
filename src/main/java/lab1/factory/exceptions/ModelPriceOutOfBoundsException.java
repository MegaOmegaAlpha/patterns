package lab1.factory.exceptions;

public class ModelPriceOutOfBoundsException extends RuntimeException {

    public ModelPriceOutOfBoundsException() {
        super("Price is invalid");
    }

}
