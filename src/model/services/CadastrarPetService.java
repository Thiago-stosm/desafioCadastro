package model.services;

import model.enums.Sexo;
import model.enums.TipoPet;
import model.exceptions.NomeIncompletoException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CadastrarPetService {

    private final Scanner scanner;

    public CadastrarPetService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void captarResposta(int numeroResposta) {

        String nomeCompleto;
        TipoPet tipoPet;
        Sexo sexo;
        String endereco;
        Integer idade;
        Double peso;
        String raca;

        for (int i = 0; i <= 7; i++) {
            switch (i) {
                case 0 -> {
                    nomeCompleto = captarNome();
                }
                case 1 -> {

                }
            }
        }
    }

    //Validações
    public String captarNome() throws NomeIncompletoException{

        while(true){
            String nomeCompleto = scanner.nextLine();
            String[] NomeCompletoArray = nomeCompleto.split(" ");
            String regexNomeCompleto = "[a-zA-Z\\s]+$";

            if (NomeCompletoArray.length < 1) {
                throw new NomeIncompletoException("Erro! Digite o nome completo do pet.");
            }
            else if(nomeCompleto.matches(regexNomeCompleto)){
                return nomeCompleto;
            }
            System.out.println("Erro! Digite um nome válido.");
        }
    }
}
