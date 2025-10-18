package application;

import java.io.IOException;
import java.util.Scanner;

import controller.MenuController;
import model.exceptions.InvalidDigitException;

import static java.lang.IO.println;

public class App {
    void main () throws InvalidDigitException, IOException {

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        menuController.executarMenu();




        sc.close();
    }
}
