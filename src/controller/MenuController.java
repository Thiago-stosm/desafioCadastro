package controller;

import model.services.MenuService;
import view.MenuView;
import controller.CadastrarPetController;

import java.io.File;
import java.util.Scanner;

public class MenuController {

    private final Scanner scanner;

    public MenuController(Scanner scanner){
        this.scanner = scanner;
    }

    public void iniciarMenu(){

        MenuView menuView = new MenuView();
        MenuService menuService = new MenuService(scanner);

        System.out.println("Bem vindo! Escolha uma das opções a seguir: ");
        menuView.mostrarOpcoes();

        int opcaoEscolhida = menuService.captarOpcaoEscolhida(scanner);
        scanner.nextLine();

        switch(opcaoEscolhida) {
            case 1 -> {
                CadastrarPetController cadastrarPetController = new CadastrarPetController(scanner);
                cadastrarPetController.realizarCadastro(new File("src/content/formulario.txt"));
            }
            case 2 -> System.out.println("n");
            case 3 -> System.out.println("n");
            case 4 -> System.out.println("n");
            case 5 -> System.out.println("n");
            case 6 -> System.out.println("Saindo...");
        }
    }
}
