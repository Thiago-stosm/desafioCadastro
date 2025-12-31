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

    public void criarPet() {

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
                    captarTipoPet();
                }
                case 2 -> {
                    captarSexo();
                }
                case 3 -> {
                    captarEndereco();
                }
                case 4 -> {
                    captarIdade();
                }
                case 5 -> {
                    captarPeso();
                }
                case 6 -> {
                    captarRaca();
                }
            }
            criarPet();
        }
    }

    //Validações
    public String captarNome() throws NomeIncompletoException{

        while(true){
            String nomeCompleto;
            if(validarNome(nomeCompleto = (scanner.nextLine()))){
                return nomeCompleto;
            };
            System.out.println("Erro! Digite um nome válido.");
        }
    }

    public void captarTipoPet(){
    }

    public void captarSexo(){}

    public void captarEndereco(){}

    public void captarIdade(){}

    public void captarPeso(){}

    public void captarRaca(){}

    public boolean validarOrtografiaNome(String nomeCompleto){
        String regexNomeCompleto = "^[a-zA-Z\\s]+$";
        nomeCompleto = nomeCompleto.trim();
        if(nomeCompleto.matches(regexNomeCompleto)){
            return true;
        }
        return false;
    }
    public boolean validarComprimentoNome(String nomeCompleto){
        boolean valido = nomeCompleto.length()>1? true : false;
        return valido;
    }
    public boolean validarNome(String nomeCompleto) throws NomeIncompletoException{
        if (validarOrtografiaNome(nomeCompleto)) {
            if (validarComprimentoNome(nomeCompleto)) {
                return true;
            }else{
                throw new NomeIncompletoException("Erro! Digite um nome completo.");
            }
        }
        return false;
    }
}
