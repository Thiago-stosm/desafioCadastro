package service;

import model.exceptions.InvalidDigitException;
import static java.lang.IO.println;

public class AuthService {

    public static void validate(int num) throws InvalidDigitException{
            if(num <= 0 || num > 6) {
                throw new InvalidDigitException("Valor inválido para o intervalo de opções...");
            }
        }
    }
