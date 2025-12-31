package controller;

import model.enums.Sexo;
import model.enums.TipoPet;
import utils.FileUtil;

import java.io.File;
import java.util.Scanner;

public class CadastrarPetController {

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
                "\nOpção escolhida: CADASTRAR NOVO PET." +
                "\nQuestões do formulário:");

        FileUtil.lerFormulario(file);
    }
}
