package model.exceptions;

import static java.lang.IO.println;

public class InvalidDigitException extends Exception{
    public InvalidDigitException(String message) {
        super(message);
    }
}
