package application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.AppController;
import model.exceptions.InvalidDigitException;
import service.AuthService;
import service.fileService;
import view.MenuView;

import static java.lang.IO.println;

public class App {
    void main () throws InvalidDigitException, IOException {

        Scanner sc = new Scanner(System.in);
        AppController appController = new AppController();

        appController.executarMenu();

        sc.close();
    }
}
