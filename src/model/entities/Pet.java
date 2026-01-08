package model.entities;

import model.enums.Sexo;
import model.enums.TipoPet;

public class Pet {

    private String nomeCompleto;
    private TipoPet tipoPet;
    private Sexo sexo;
    private String endereco;
    private Integer idade;
    private Double peso;
    private String raca;

    public Pet(String nomeCompleto, TipoPet tipoPet, Sexo sexo, String endereco, Integer idade, Double peso, String raca) {
        this.nomeCompleto = nomeCompleto;
        this.tipoPet = tipoPet;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", tipoPet=" + tipoPet +
                ", sexo=" + sexo +
                ", endereco='" + endereco + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", raca='" + raca + '\'' +
                '}';
    }
}
