package model.exceptions;

public class WeightOutBoundException extends RuntimeException {
    public WeightOutBoundException(String message) {
        super(message);
    }
}
