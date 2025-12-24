package utils;

import controller.CadastrarPetController;
import model.services.CadastrarPetService;

import java.io.*;

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
}
