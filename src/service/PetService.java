package service;

import model.entities.Pet;
import model.enums.PetType;
import model.enums.Sex;
import model.exceptions.IncompleteNameException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;

import static java.lang.IO.println;

public class PetService {

    public String inputName() throws IncompleteNameException {
        Scanner sc = new Scanner(System.in);

        String name = null;

        while(true){
                name = sc.nextLine();
                if(name.trim().matches("[a-zA-Z ]+")){
                    String[] split = name.split("\\s+");
                    if(split.length > 1){
                        return name;
                    }else{
                        throw new IncompleteNameException("Erro! Nome incompleto...");
                    }
                }
                println("Digite um nome válido...");
            }
    }


}
