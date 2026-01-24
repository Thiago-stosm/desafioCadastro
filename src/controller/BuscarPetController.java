package controller;

import model.exceptions.PesoForaDoLimiteException;
import model.services.BuscarPetService;
import model.services.CadastrarPetService;
import view.BuscarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscarPetController {

    private final Scanner scanner;

    public BuscarPetController(Scanner scanner){
        this.scanner = scanner;
    }

    public void iniciarBusca(){
        BuscarPetService buscarPetService = new BuscarPetService(scanner);
        System.out.println("\nOpção escolhida: BUSCAR DADOS DE UM PET CADASTRADO.\n");
        System.out.println("\nCritérios de busca:\n ");
        System.out.println(BuscarView.criteriosDeBusca);
        System.out.println("Você utilizará um ou dois critérios de busca? (1/2): ");
        int qtdCriterios = buscarPetService.captarQtdCriterios();

        List<String> criterios = new ArrayList<>();

        criterios.add(buscarPetService.captarCriterioTipoPet());
        for(int x=0; x<= qtdCriterios; x++){
            String criterio = buscarPetService.captarCriterio();
            criterios.add(criterio);
        }
    }



}
