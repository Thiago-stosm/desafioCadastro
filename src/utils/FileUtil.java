package utils;

import controller.CadastrarPetController;
import model.services.CadastrarPetService;

import java.io.*;

import static java.lang.IO.print;

public class FileUtil {

    private final CadastrarPetService cadastrarPetService;

    public FileUtil(CadastrarPetService cadastrarPetService){
        this.cadastrarPetService = cadastrarPetService;
    }
    public File criarArquivo(String nomeArquivo){
        File file = new File(nomeArquivo);
        return file;
    }

    public void lerFormulario(File file){
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linha;
            for(int i=0;i<=13;i++){
                while((linha = br.readLine()) != null){
                    print(linha);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
