package model.services;

import model.entities.Pet;
import model.enums.Sexo;
import model.enums.TipoPet;
import model.exceptions.IdadeForaDoLimiteException;
import model.exceptions.NomeIncompletoException;
import model.exceptions.PesoForaDoLimiteException;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CadastrarPetService {

    private final Scanner scanner;

    public CadastrarPetService(Scanner scanner) {
        this.scanner = scanner;
    }

    public Pet criarPet() {

        String nomeCompleto=null;
        TipoPet tipoPet=null;
        Sexo sexo=null;
        String endereco=null;
        Integer idade=null;
        Double peso=null;
        String raca=null;

        for (int i = 0; i <= 7; i++) {
            switch (i) {
                case 0 -> {
                    nomeCompleto = captarNome();
                }
                case 1 -> {
                    tipoPet = captarTipoPet();
                    //System.out.println(tipoPet.getValor());
                }
                case 2 -> {
                    sexo = captarSexo();
                    //System.out.println(sexo.getValor());
                }
                case 3 -> {
                    endereco = captarEndereco();
                }
                case 4 -> {
                    idade = captarIdade();
                }
                case 5 -> {
                    peso = captarPeso();
                }
                case 6 -> {
                    raca = captarRaca();
                }
            }
        }

        Pet pet = new Pet(nomeCompleto, tipoPet, sexo, endereco, idade, peso, raca);
        System.out.println(pet);
        return pet;
    }

    //Validações
    public String captarNome() throws NomeIncompletoException{

        String nomeCompleto;
        System.out.println("\n1. Nome e sobrenome: " +
                "\nDigite o nome completo do pet: ");
        while(true){
            nomeCompleto = scanner.nextLine();
            if(validarNome(nomeCompleto)){
                return nomeCompleto;
            }
            System.out.println("Erro! Digite um nome válido.");
        }
    }
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

    public TipoPet captarTipoPet(){

        System.out.println("\n2. Tipo do Pet: " +
                "\nDigite o tipo do Pet (gato/cachorro):");

        while(true){
            try{
                String valor = scanner.nextLine();
                TipoPet tipoPet  = TipoPet.tipoPetPorValor(valor);
                return tipoPet;
            }catch(IllegalArgumentException e){
                System.out.println("Erro! Digite um tipo válido (cachorro/gato).");
            }
        }
    }

    public Sexo captarSexo(){

        System.out.println("\n3. Sexo do Pet: " +
                "Digite o sexo do Pet (macho/femea): ");

        while(true){
            try{
                String valor = scanner.nextLine();
                Sexo sexo = Sexo.sexoPorValor(valor);
                return sexo;
            }catch(IllegalArgumentException e){
                System.out.println("Erro! Digite um sexo válido (macho/femea).");
            }
        }

    }

    public String captarEndereco(){

        System.out.println("\n4. Endereço completo: ");
        return  captarRuaEndereco() + ", " + String.valueOf(captarNumeroEndereco()) + ", " + captarCidadeEndereco();

    }
    public int captarNumeroEndereco(){

        System.out.println("\n4.2. Digite o número do endereço: ");

        while(true){
            try{
               int numeroEndereco = Integer.parseInt(scanner.nextLine());
               return numeroEndereco;
            }catch(NumberFormatException e){
                System.out.println("Erro! Digite um número válido.");
            }
        }

    }
    public String captarRuaEndereco(){

        String regexNomeDaRua  = "^[a-zA-Z\\s]+$";
        System.out.println("\n4.1. Digite o nome da rua: ");

        while(true){
            String nomeRua = scanner.nextLine();

            if(nomeRua.trim().matches(regexNomeDaRua)){
                return nomeRua;
            }
            else{
                System.out.println("Erro! Digite um nome válido.");
            }
        }
    }
    public String captarCidadeEndereco(){

        String regexNomeDaRua  = "^[a-zA-Z\\s]+$";
        System.out.println("\n4.3. Digite o nome da cidade onde o endereço está localizado: ");

        while(true) {
            String nomeCidade = scanner.nextLine();

            if (nomeCidade.trim().matches(regexNomeDaRua)) {
                return nomeCidade;
            } else {
                System.out.println("Erro! Digite um nome válido.");
            }
        }
    }

    public int captarIdade(){
        System.out.println("\n5. Captar Idade: ");

        while(true){
            try{
                int idadePet = Integer.parseInt(scanner.nextLine());
                if(validarIdadePet(idadePet)){
                    return idadePet;
                }
                throw new IdadeForaDoLimiteException("Erro! Digite uma idade válida (abaixo ou igual a 20 anos).");

            }catch(NumberFormatException e){
                System.out.println("Erro! Digite um valor válido!");
            }
        }
    }
    public boolean validarIdadePet(int idadePet){
        return idadePet <= 20 && idadePet >= 0 ;
    }

    public double captarPeso(){

        System.out.println("\n6. Captar peso: ");

        while(true){
            try{
                double peso;
                peso = Double.parseDouble(scanner.nextLine());
                if(validarPeso(peso)){
                    return peso;
                }
                throw new PesoForaDoLimiteException("Erro! Digite um peso válido (entre 0.5kg e 60kg).");
            }catch(NumberFormatException e){
                System.out.println("Erro! Digite um valor válido.");
            }
        }
    }
    public boolean validarPeso(double peso){
        return (peso > 0.5 && peso < 60);
    }

    public String captarRaca(){

        System.out.println("\n7. Captar raça: ");
        while(true){
            String raca;
            raca = scanner.nextLine();
            if(validarRaca(raca)){
                return raca;
            }
            System.out.println("Erro! Digite um valor válido.");
        }
    }
    public boolean validarRaca(String raca){
        String regexRaca = "^[a-zA-Z\\s]+$";
        return raca.matches(regexRaca);
    }


}
