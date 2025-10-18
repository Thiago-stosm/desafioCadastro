package view;

import java.util.Scanner;

import static java.lang.IO.println;

public class MenuView {

    private final Scanner sc = new Scanner(System.in);

    public void mostrarBoasVindas(){
        println("BEM VINDO AO NOSSO SISTEMA DE CADASTRO DE PETS!\n"
        + "\nEstas são as informações requiridas no cadastro de novos animais:");
    }

    public void mostrarMenuOpcoes(){
        println("-----------------------------------------------------------------");
        println("\nMENU DE OPÇÕES\n"
        + "1. Cadastrar um novo pet\n"
        + "2. Alterar os dados do pet cadastrado\n"
        + "3. Deletar um pet cadastrado\n"
                + "4. Listar todos os pets cadastrados\n"
        + "4. Listar pets por algum critério (idade, nome, raça)\n"
        + "6. Sair\n");
    }
    
    public void solicitarInput(){
        println("Digite uma das opções: ");
    }
}
