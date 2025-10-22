package service;

import model.enums.PetType;
import model.enums.Sex;
import model.exceptions.AgeOutBoundException;
import model.exceptions.IncompleteNameException;
import model.exceptions.WeightOutBoundException;
import model.utils.Constants;

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
                    if(name.trim().isEmpty() || name == null){
                        return Constants.INPUT_NULL;
                    }
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

        double age=0.0;
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

    public Double inputWeight(){
        double weight=0;

        while (true) {
            try{
                weight = sc.nextDouble();
                if(weight < 0.5 || weight > 60){
                    throw new WeightOutBoundException("Erro! Digite um peso válido (entre 0.5 e 60 kg)...");
                }
                return weight;
            }catch(InputMismatchException e){
                println("Erro! Digite um valor válido...");
            }
        }
    }

    public String inputBreed(){

        String breed = null;
        while(true){
              breed  = sc.nextLine();
              if(breed.matches("[a-zA-Z ]+]")){
                  return breed;
              }else{
                  print("Erro! Digite um valor válido...");
              }
        }
    }

}
