package controller;

import utils.FileUtil;

import java.io.File;
import java.util.Scanner;

public class CadastrarPetController {

    private final Scanner scanner;

    //Construtor
    public CadastrarPetController(Scanner scanner){
        this.scanner = scanner;
    }

    public void realizarCadastro(File file){
        System.out.println("\nOPÇÃO ESCOLHIDA: CADASTRAR NOVO PET." +
                "\nQuestões do formulário");
        FileUtil.lerFormulario(file);



    }
}
