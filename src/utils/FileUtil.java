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
import java.util.*;

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
            bw.write("6 - " + pet.getPeso() + " kg");
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
        if(diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles();
            return arquivos != null? arquivos : new File[0];
        }else{
            throw new FileNotFoundException();
        }
    }

    public static ArrayList<File> validarListaDeArquivos(File[] listaDeArquivos, ArrayList<String> criterios) throws IOException {

        ArrayList<File> listaDeArquivosCompativeis = new ArrayList<>();

        for(File arquivo : listaDeArquivos){
            if(arquivo.isDirectory()){
                listaDeArquivosCompativeis.addAll(validarListaDeArquivos(arquivo.listFiles(), criterios));
            }
            if(arquivo.isFile()){
                if(validarArquivo(arquivo, criterios)){
                    listaDeArquivosCompativeis.add(arquivo);
                }
            }
        }
        return listaDeArquivosCompativeis;
    }

    public static boolean validarArquivo(File arquivo, List<String> criterios){

        Set<String> setCriterios = new HashSet<>();

        for(String criterio : criterios){ // Esse método adiciona ao Set todos os critérios normalizados
            criterio = FileUtil.normalizarTexto(criterio);
            setCriterios.add(criterio);
        }

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while((linha = br.readLine()) != null){
                FileUtil.validarLinha(linha, setCriterios);
            }
            return setCriterios.isEmpty();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String normalizarTexto(String texto){
        return texto.trim().toLowerCase();
    }

    public static void validarLinha(String linha, Set<String> setCriterios){

        linha = FileUtil.normalizarTexto(linha);

        Iterator<String> iteratorSetCriterios = setCriterios.iterator(); // Cria um iterator

        while(iteratorSetCriterios.hasNext()){
            String criterio = iteratorSetCriterios.next();

            if(linha.contains(criterio)){
                iteratorSetCriterios.remove();
            }
        }
    }

    public static ArrayList<String> criarArrayDeLinhasDoArquivo(File file){

        ArrayList<String> linhasDoArquivo = new ArrayList<>();
        String linha;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while((linha = br.readLine()) != null){
                linha = linha.substring(3);
                linhasDoArquivo.add(linha);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linhasDoArquivo;
    }

    public static String gerarConteudoDeExibicaoDoArquivo(ArrayList<String> linhasDoArquivo){
        String conteudo = "";

        for(int i=0; i< linhasDoArquivo.size(); i++){
            if(i == linhasDoArquivo.size()-1){
                String elementoDaLista = linhasDoArquivo.get(i);
                conteudo += elementoDaLista;
            }
            else{
                String elementoDaLista = linhasDoArquivo.get(i) + " - ";
                conteudo += elementoDaLista;
            }
        }
        return conteudo;
    }

    public static void exibirArquivos(ArrayList<File> listaDeArquivosCompativeis){

        int i = 1;

        for(File file : listaDeArquivosCompativeis){
          ArrayList<String> linhasDoArquivo = criarArrayDeLinhasDoArquivo(file);
          String conteudo = String.valueOf(i) + ". ";
          conteudo += gerarConteudoDeExibicaoDoArquivo(linhasDoArquivo);
          System.out.println(conteudo);
          i++;
        }
    }

}
