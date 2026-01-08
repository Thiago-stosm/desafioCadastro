package controller;

import model.enums.Sexo;
import model.enums.TipoPet;
import utils.FileUtil;
import model.services.CadastrarPetService;

import java.io.File;
import java.util.Scanner;

public class CadastrarPetController {

    CadastrarPetService cadastrarPetService;
    private final Scanner scanner;

    String nomeCompleto;
    TipoPet tipoPet;
    Sexo sexo;
    String endereco;
    Integer idade;
    Double peso;
    String raca;

    //Construtor
    public CadastrarPetController(Scanner scanner){
        this.scanner = scanner;
    }

    public void realizarCadastro(File file){

        System.out.println(
                "\nOpção escolhida: CADASTRAR NOVO PET.\n" +
                "\nQuestões do formulário:");

        FileUtil.lerFormulario(file);

        CadastrarPetService cadastrarPetService = new CadastrarPetService(scanner);
        cadastrarPetService.criarPet();
    }
}
