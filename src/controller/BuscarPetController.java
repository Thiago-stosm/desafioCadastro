package controller;

import model.exceptions.PesoForaDoLimiteException;
import model.services.BuscarPetService;
import model.services.CadastrarPetService;
import utils.FileUtil;
import view.BuscarView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

        System.out.println("DEBUG - QTD DE CRITÉRIOS : "+qtdCriterios);

        ArrayList<String> criterios = new ArrayList<>();

        System.out.println("Antes, precisamos que você informe o tipo do pet (cachorro/gato).");
        String tipoPet = (buscarPetService.captarCriterioTipoPet());
        System.out.println("DEBUG - TIPO PET: "+tipoPet);
        criterios.add(tipoPet);
        System.out.println("DEBUG - LISTA DE CRITERIOS: "+criterios);

        for(int x=0; x<= qtdCriterios; x++){
            String criterio = buscarPetService.captarCriterioPorIndex();
            criterios.add(criterio);
        }

        File[] listaDeArquivos;

        try {
            listaDeArquivos = FileUtil.listarArquivos();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Erro! Arquivos não encontrados.");
        }

        ArrayList<File> listaDeArquivosCompativeis = new ArrayList<>();
        try {
            listaDeArquivosCompativeis = FileUtil.validarListaDeArquivos(listaDeArquivos, criterios);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao validar lista...");
        }

        // Agora eu tenho a lista de arquivos compatíveis, preciso printar os arquivos somente
    }





}
