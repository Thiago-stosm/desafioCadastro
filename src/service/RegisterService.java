package service;

import model.entities.Pet;
import model.enums.PetType;
import model.enums.Sex;
import model.exceptions.IncompleteNameException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.IO.println;

public class RegisterService {
    public static void register(String path) {
        Scanner sc = new Scanner(System.in);
        PetService petService = new PetService();

        String firstname = null;
        String lastname = null;
        Sex sex = null;
        PetType petType = null;
        String address = null;
        String district = null;
        Double age = null;
        Double weight = null;
        String breed = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            int contador = 1;

            while ((linha = br.readLine()) != null) {
                println(linha);

                switch (contador){

                    case 1:
                        String name = petService.inputName();
                        String[] names = name.split("\\s+");
                        firstname = names[0];
                        lastname = names[1];
                        break;
                    case 2:
                        petType = petService.inputPetType();
                        break;
                    case 3:
                        sex = petService.inputSex();
                        break;
                    case 4:
                        List<String> fullAddress = petService.inputFullAddress();
                        address = fullAddress.getFirst() + "" + fullAddress.get(1) + "" + fullAddress.get(2);
                        break;
                    case 5:
                        age = petService.inputAge();
                        sc.nextLine();
                        break;
                    case 6:
                        weight = petService.inputWeight();
                        sc.nextLine();
                        break;
                    case 7:
                        breed = petService.inputBreed();
                        break;
                }
                contador++;
            }

            println("Fim dos dados necessários. Total de dados coletados: " + (contador - 1));

        } catch (IOException | IncompleteNameException e) {
            println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            sc.close();
        }

        Pet pet = new Pet(firstname, lastname, sex, petType, address, district, age, weight, breed);
        String string = pet.toString();
        println(string);
    }
}
