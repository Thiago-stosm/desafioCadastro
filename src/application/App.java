package application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.exceptions.InvalidDigitException;
import service.AuthService;
import service.fileService;

import static java.lang.IO.println;

public class App {
    void main () throws InvalidDigitException, IOException {
        Scanner sc = new Scanner(System.in);

        println("BEM VINDO AO NOSSO CADASTRO DE PETS \n" + "Estas são as informações que coletamos para o cadastro: ");
        fileService.reader("C:/pet/formulario.txt");

        println("\nMENU DE OPÇÕES\n" +
                        "1. Cadastrar novo pet \n" +
                        "2. Alterar os dados do pet cadastrado\n" +
                        "3. Deletar um pet cadastrado\n" +
                        "4. Listar todos os pets cadastrados\n" +
                        "5. Listar pets por algum critério (idade, nome, raça)\n" +
                        "6. Sair"
                );

        println("Por favor, selecione uma opção: ");

        int selection=0;

        while(true){
            try {
                selection = sc.nextInt();
                AuthService.validate(selection);
                println("Você selecionou: " + selection);
                break;

            }catch(InputMismatchException e){
                println("Insira um número inteiro dentre intervalo de opções...");
                sc.nextLine();
            }
            catch(InvalidDigitException e){
                println("Este valor é inválido dentre as opções...");
            }
        }

        switch (selection){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }

        sc.close();
    }
}
