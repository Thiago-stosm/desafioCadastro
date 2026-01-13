package utils;

import controller.CadastrarPetController;
import model.entities.Pet;
import model.services.CadastrarPetService;
import org.w3c.dom.ls.LSOutput;
import utils.test.DateUtil;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;

public class FileUtil {

    private FileUtil(){}

    public static File criarArquivo(Pet pet){

        File file = new File("output/" + FileUtil.gerarNomeDoArquivo(pet));

        FileUtil.checarDiretorio(file);

        try{
            confirmarCriacaoDoArquivo(file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public static String gerarNomeDoArquivo(Pet pet){

        String data = DateUtil.formatarData(DateUtil.captarDataLDT());
        String nomePet = pet.getNomeCompleto();
        return data + "-" + nomePet.toUpperCase() + ".TXT";
    }

    public static void checarDiretorio(File file){
        File parent = file.getParentFile();
        if(parent != null && !parent.exists()){
            parent.mkdirs();
        }
    }

    public static void confirmarCriacaoDoArquivo(boolean foiCriado){
        String seSucesso = "Arquivo do pet criado com sucesso.";
        String seFracasso = "Erro! Não foi possível criar o arquivo.";
        String resposta = foiCriado? seSucesso : seFracasso;
        System.out.println(resposta);
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
