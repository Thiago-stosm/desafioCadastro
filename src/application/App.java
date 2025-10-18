package application;

import java.io.IOException;
import controller.MenuController;
import model.exceptions.InvalidDigitException;

import static java.lang.IO.println;

public class App {
    void main () throws InvalidDigitException, IOException {
        MenuController menuController = new MenuController();
        menuController.executarMenu();
    }
}
