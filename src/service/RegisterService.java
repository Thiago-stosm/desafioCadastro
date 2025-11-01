package service;

import model.entities.Pet;
import model.enums.PetType;
import model.enums.Sex;
import model.exceptions.IncompleteNameException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static java.lang.IO.println;
import static java.time.OffsetDateTime.now;

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

    public static void createPetFile(Pet pet){
        OffsetDateTime now = now();
        String dateArchive = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
        dateArchive = dateArchive.replace(":", "");
        String archiveName = dateArchive + "-" + pet.getFirstname().toUpperCase() + pet.getLastname().toUpperCase();
        try{
            File newFile = new File("C:/Users/LENOVO/Documents/Thiago/ProjetosPessoais/desafioCadastro/petsCadastrados", archiveName + ".TXT");
            if (newFile.createNewFile()) {
                System.out.println("Arquivo criado: " + newFile.getName());
            } else {
                System.out.println("O arquivo já existe.");
            }
        } catch (IOException e) {
            println("Ocorreu um erro.");
        }
    }
}
