package service;

import model.exceptions.InvalidDigitException;

import java.util.List;

import static java.lang.IO.println;

public class MenuService {

    public static boolean validate(int num) throws InvalidDigitException{

        List<Integer> options = List.of(1, 2, 3, 4, 5, 6);

            if (options.contains(num)) {
                return true;
            }
            throw new InvalidDigitException("Dígito inexistente entre as opções.");
        }
    }

