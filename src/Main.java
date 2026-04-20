import controller.MenuController;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        MenuController menuController = new MenuController(scanner);
        menuController.iniciarMenu();
        System.out.println(
            "Corinthians!!"
        );
    }

