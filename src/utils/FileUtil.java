package utils;

import controller.CadastrarPetController;
import model.entities.Pet;
import model.services.CadastrarPetService;
import utils.test.DateUtil;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;

public class FileUtil {

    public static File criarArquivo(String nomeArquivo){
        return new File(nomeArquivo);
    }

    public static void lerFormulario(File file){
        try{
            BufferedReader br =  new BufferedReader(new FileReader(file));
            String linha;

            while(((linha = br.readLine()) != null)){
                System.out.println(linha);
            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public String gerarNomeDoArquivo(Pet pet){

        String data = DateUtil.formatarData(DateUtil.captarDataLDT());
        String nomePet = pet.getNomeCompleto();
        return data + "-" + nomePet.toUpperCase() + ".TXT";
    }

}
