package controller;

import model.exceptions.InvalidDigitException;
import service.FileService;
import service.MenuService;
import view.MenuView;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.IO.println;

public class MenuController {

    public MenuController(){
    }

    public void executarMenu() throws IOException, InvalidDigitException {

        Scanner sc = new Scanner(System.in);
        MenuView menuView = new MenuView();

        menuView.mostrarBoasVindas();
        FileService.reader("C:/Users/LENOVO/Documents/Thiago/ProjetosPessoais/desafioCadastro/resources/formulario.txt");
        menuView.mostrarMenuOpcoes();
        menuView.solicitarInput();

        int num = 0;
        while(true){
            try{
                MenuService.validate(num = sc.nextInt());
                break;
            }catch (InvalidDigitException e){
                println("Digite um valor válido dentre as opções...");
            }catch (InputMismatchException e){
                println("Digite um número inteiro dentre as opções...");
            }
            sc.nextLine();
        }

        switch(num){
            case 1 -> {
                RegisterController registerController = new RegisterController();
                registerController.execute();
            }
            case 2 -> {
                UpdateController updateController = new UpdateController();
            }
            case 3 -> {
                DeleteController deleteController = new DeleteController();
            }
            case 4 -> {
                ListAllController listAllController = new ListAllController();
            }
            case 5 -> {
                FilterListController filterListController = new FilterListController();
            }
            case 6 -> {
                GoOutController goOutController = new GoOutController();
            }
        }
    }
}
