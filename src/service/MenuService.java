package service;

import model.exceptions.InvalidDigitException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.IO.println;

public class AuthService {

    public static boolean validate(int num) throws InvalidDigitException{

        List<Integer> options = List.of(1, 2, 3, 4, 5, 6);

            return options.contains(num);
        }
    }

