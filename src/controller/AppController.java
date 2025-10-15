package controller;

import model.exceptions.InvalidDigitException;
import service.AuthService;
import service.fileService;
import view.MenuView;

import java.io.IOException;

public class AppController {

    public AppController(){
    }

    public void executarMenu() throws IOException, InvalidDigitException {

        MenuView menuView = new MenuView();

        menuView.mostrarBoasVindas();
        fileService.reader("C:/Users/LENOVO/Documents/Thiago/ProjetosPessoais/desafioCadastro/resources/formulario.txt");

        menuView.mostrarMenuOpcoes();

        AuthService.validate(menuView.solicitarInput());
    }
}
