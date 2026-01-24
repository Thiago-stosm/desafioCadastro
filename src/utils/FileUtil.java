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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    /*TODO
    * Esse método abaixo possui um problema semântico:
    * - possui uma classe inserirConteudoNoArquivo
    * - essa classe possui outra classe interna escreverConteudoDoFormulario
    * Viu? Tem um problema semântico grave, métodos com nome semelhantes e funções diferentes
    * */
    public static void inserirConteudoNoArquivo(File file, Pet pet){
        try(FileWriter fw = new FileWriter(file, true)) {

            BufferedWriter bw = new BufferedWriter(fw);
            escreverConteudoDoFormulario(bw, pet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void escreverConteudoDoFormulario(BufferedWriter bw, Pet pet) throws IOException {
        try{
            bw.write("1 - " + pet.getNomeCompleto());
            bw.newLine();
            bw.write("2 - " + pet.getValorTipoPet());
            bw.newLine();
            bw.write("3 - " + pet.getValorSexoPet());
            bw.newLine();
            bw.write("4 - " + pet.getEndereco());
            bw.newLine();
            bw.write("5 - " + pet.getIdade() + " anos");
            bw.newLine();
            bw.write("6 - " + pet.getPeso() + "kg");
            bw.newLine();
            bw.write("7 - " + pet.getRaca());
            bw.close();
        }catch(IOException e){
        }
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

    public static File[] listarArquivos() throws FileNotFoundException {
        File diretorio = new File("/home/thiago/Documentos/projetos/desafioCadastro/output");
        if(diretorio.exists()) {
            return diretorio.listFiles();
        }else{
            throw new FileNotFoundException();
        }
    }

    public static File retornaArquivoProcurado(File[] listaDeArquivos, String filtroDeBusca) throws FileNotFoundException {
        // Listar arquivos

        for (File file : listaDeArquivos){

            try{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while(!((linha = br.readLine()) == null)){
                    if(linha == filtroDeBusca){
                        return file;
                    }
                }
            }catch (FileNotFoundException e){
                System.out.println("Erro! Arquivo não encontrado.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
