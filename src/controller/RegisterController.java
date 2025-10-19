package controller;

import service.RegisterService;
import view.RegisterView;

import java.util.Scanner;

public class RegisterController {

    public RegisterController(){
    }

    public void execute(){
        RegisterView registerView = new RegisterView();
        RegisterService registerService = new RegisterService();
        Scanner sc = new Scanner(System.in);

        registerView.showSelection();
        registerService.register("C:/Users/LENOVO/Documents/Thiago/ProjetosPessoais/desafioCadastro/resources/formulario.txt");


    }


}
