package model.enums;

public enum TipoPet {

    GATO("gato", 1),
    CACHORRO("cachorro", 2);

    public final int VALOR;

    TipoPet(String nome, int VALOR){
        this.VALOR = VALOR;
    }
}
