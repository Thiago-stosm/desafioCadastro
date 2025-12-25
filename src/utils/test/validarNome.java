package utils.test;

import model.exceptions.NomeIncompletoException;

import java.util.Scanner;

public class validarNome {
    private static final Scanner scanner = new Scanner(System.in);

    public static String captarNomeTeste() throws NomeIncompletoException{

        while(true){
            String nomeCompleto = scanner.nextLine();
            String[] NomeCompletoArray = nomeCompleto.split(" ");
            String regexNomeCompleto = "[a-zA-Z\\s]+$";

            if ((NomeCompletoArray.length) < 1) {
                throw new NomeIncompletoException("Erro! Digite o nome completo do pet.");
            }
            else if(nomeCompleto.matches(regexNomeCompleto)){
                System.out.println("Nome: "+ nomeCompleto);
                return nomeCompleto;
            }
            System.out.println("Erro! Digite um nome válido.");
        }
    }

    public static void main(String [] args){
        String nomeCompleto = captarNomeTeste();
    }
}

//1. Nome único está passando sem problemas
//2. Quando eu não digito nada, ele ainda não solta a excessão, e passa pelos dois booleanos if-else