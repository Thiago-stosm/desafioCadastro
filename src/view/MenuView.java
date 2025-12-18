package view;

import static java.lang.IO.println;

public class MenuView {
    public MenuView(){
    }
    public void menuDeOpcoes(){
        println(
                        "\n1.Cadastrar um novo pet" +
                        "\n2.Alterar os dados do pet cadastrado" +
                        "\n3.Deletar um pet cadastrado" +
                        "\n4.Listar todos os pets cadastrados" +
                        "\n5.Listar pets por algum critério (idade, nome, raça)" +
                        "\n6.Sair"

        );
    }
}
