package model.services;

import model.enums.TipoPet;
import model.exceptions.PesoForaDoLimiteException;
import view.BuscarView;

import java.util.Scanner;

public class BuscarPetService {

    private final Scanner scanner;

    public BuscarPetService(Scanner scanner){
        this.scanner = scanner;
    }

    public String captarCriterioTipoPet(){
        while(true){
            try{
                String valor = scanner.nextLine();
                TipoPet tipoPet  = TipoPet.tipoPetPorValor(valor);
                return tipoPet.toString();
            }catch(IllegalArgumentException e){
                System.out.println("Erro! Digite um tipo válido (cachorro/gato).");
            }
        }
    }

    public int captarQtdCriterios(){
        while(true){
            try{
                return Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Erro! Digite um valor válido.");
            }
        }
    }

    public String captarCriterio(){

        while(true){
            System.out.println(BuscarView.criteriosDeBusca);
            System.out.println("\nDigite o index do critério que deseja utilizar: ");
            int indexCriterio = captarIndexCriterio();

        }
    }

    public int captarIndexCriterio(){

        int[] valoresValidos = {1, 2, 3, 4, 5, 6};

        while(true){
            try{
                int indexCriterio  = Integer.parseInt(scanner.nextLine());
                for(int n : valoresValidos){
                    if (indexCriterio == n){
                        return indexCriterio;
                    }
                    System.out.println("Erro! Digite um valor válido.");
                }
            }catch(NumberFormatException e){
                System.out.println("Erro! Digite um valor válido.");
            }
        }
    }

    public String captarValorDoCriterio(int indexCriterio){

        String valor = null;

        switch(indexCriterio){
            case 1 -> {
                valor = captarCriterioNome();
            }
            case 2 -> {
                valor = captarCriterioSexo();
            }
            case 3 -> {
                valor = captarCriterioIdade();
            }
            case 4 -> {
                valor = captarCriterioPeso();
            }
            case 5 -> {
                valor = captarCriterioRaca();
            }
            case 6 -> {
                valor = captarCriterioEndereco();
            }
        }
        return valor;
    }

    public String captarCriterioNome(){

        String regexNome = "^[a-zA-Z\\s]+$";

        while(true){
            String nome = scanner.nextLine();
            nome = nome.trim();
            if(nome.matches(regexNome)){
                return nome;
            }
            System.out.println("Erro! Digite um valor válido.");
        }
    }

    public String captarCriterioSexo(){

        while(true){
            System.out.println("Critério: SEXO\n");
            System.out.println("Digite o sexo do Pet (Macho/Femea):\n");

            String sexo = scanner.nextLine();
            boolean valido = (sexo).equalsIgnoreCase("MACHO") || (sexo).equalsIgnoreCase("MACHO");

            if(valido){
                return sexo;
            }
            System.out.println("Erro! Digite um valor válido (Macho/Femea)!");
        }
    }

    public String captarCriterioIdade(){
        while(true){
            System.out.println("Critério: IDADE\n");
            System.out.println("Digite a idade do Pet (máx: 20 anos):\n");
            try{
                int idade = Integer.parseInt(scanner.nextLine());
                boolean valido = idade > 0 && idade <= 20;
                if(valido){
                    return String.valueOf(valido);
                }
                System.out.println("Erro! Digite uma idade válida (abaixo ou igual a 20 anos).");
            }catch(NumberFormatException e){
                System.out.println("Erro! Digite um valor válido.");
            }
        }
    }

    public String captarCriterioPeso(){
        while(true){
            try{
                double peso;
                peso = Double.parseDouble(scanner.nextLine());
                if((peso > 0.0 && peso <= 60.00)){
                    return String.valueOf(peso);
                }
                throw new PesoForaDoLimiteException("Erro! Digite um peso válido (entre 0.5kg e 60kg).");
            }catch(NumberFormatException e){
                System.out.println("Erro! Digite um valor válido.");
            }
        }
    }

    public String captarCriterioRaca(){
        String regexRaca = "^[a-zA-Z\\s]+$";

        while(true){
            String raca = scanner.nextLine();
            raca = raca.trim();
            if(raca.matches(regexRaca)){
                return raca;
            }
            System.out.println("Erro! Digite um valor válido.");
        }
    }

    public String captarCriterioEndereco(){
        CadastrarPetService cadastrarPetService = new CadastrarPetService(scanner);
        return cadastrarPetService.captarEndereco();
    }
}
