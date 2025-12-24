package model.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.IO.println;

public class MenuService {

    private final Scanner scanner;

    public MenuService(Scanner scanner){
        this.scanner = scanner;
    }
    public int captarOpcaoEscolhida(Scanner scanner){
        while(true){
            try{
                int opcaoEscolhida = scanner.nextInt();
                if(opcaoEscolhida <= 6 && opcaoEscolhida >=1){
                    return opcaoEscolhida;
                }else{
                    println("Erro! Digite um valor inteiro entre 1 e 6.");
                    scanner.nextLine();
                }
            }catch(InputMismatchException e){
                println("Erro! Digite um valor válido.");
            }
        }
    }


}
