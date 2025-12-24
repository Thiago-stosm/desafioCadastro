package controller;

import model.services.MenuService;
import view.MenuView;
import controller.CadastrarPetController;
import java.util.Scanner;

import static java.lang.IO.println;

public class MenuController {

    private final Scanner scanner;

    public MenuController(Scanner scanner){
        this.scanner = scanner;
    }

    public void iniciarMenu(){

        MenuView menuView = new MenuView();
        MenuService menuService = new MenuService(scanner);

        println("Bem vindo! Escolha uma das opções a seguir: ");
        menuView.mostrarOpcoes();

        switch(menuService.captarOpcaoEscolhida(scanner)) {
            case 1 -> {
                CadastrarPetController cadastrarPetController = new CadastrarPetController();
                cadastrarPetController.iniciarCadastro();
            }
            case 2 -> println("n");
            case 3 -> println("n");
            case 4 -> println("n");
            case 5 -> println("n");
            case 6 -> println("Saindo...");
        }
    }
}
