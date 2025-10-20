package service;

import model.enums.PetType;
import model.enums.Sex;
import model.exceptions.AgeOutBoundException;
import model.exceptions.IncompleteNameException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.IO.print;
import static java.lang.IO.println;

public class PetService {
    Scanner sc = new Scanner(System.in);

    public String inputName() throws IncompleteNameException {

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

    public PetType inputPetType() {

        while(true){
            String type = (sc.nextLine()).toLowerCase();
            if (type.equals("cachorro") || type.equals("gato")){
                switch(type){
                    case "cachorro" -> {return PetType.DOG; }
                    case "gato" -> {return PetType.CAT;}
                    default -> throw new IllegalStateException("Unexpected value: " + type);
                }
            }
            else{
                print("Erro! Digite um tipo válido (dog/cat)...");
            }
        }
    }

    public Sex inputSex(){
        while(true){
            String type = (sc.nextLine()).toLowerCase();
            if (type.equals("male") || type.equals("female")){
                switch(type){
                    case "male" -> {return Sex.MALE;}
                    case "female" -> {return Sex.FEMALE;}
                }
            }
            else{
                print("Erro! Digite um tipo válido (male/female)...");
            }
            sc.close();
        }
    }

    public List<String> inputFullAddress(){

        List<String> fullAddress = new ArrayList<>();

        println("I. Número da casa: ");
        try{
            fullAddress.add(String.valueOf(sc.nextInt()));
            sc.nextLine();
        }catch(InputMismatchException e){
            println("Erro! Digite um digito válido...");
        }

        println("II. Cidade: ");
        fullAddress.add(sc.nextLine());

        println("III. Rua: ");
        fullAddress.add(sc.nextLine());

        return fullAddress;
    }

    public Double inputAge(){

        Double age=0.0;
        while(true){
            try{
                String input = sc.nextLine();
                input = input.replace('.', ',');
                age = Double.parseDouble(input);
                if(age > 20){
                    throw new AgeOutBoundException("Erro! Idade acima do limite permitido...");
                }
                else if(age < 1){
                    age = (age/12);
                }
                return age;
            }catch(InputMismatchException e){
                println("Erro! Digite um valor válido...");
                sc.nextLine();
            } catch (AgeOutBoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
