package model.enums;

public enum TipoPet {

    GATO("Gato"),
    CACHORRO("Cachorro");

    private String valor;

    TipoPet(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return this.valor;
    }

    public static TipoPet tipoPetPorValor(String valor){

            for(TipoPet tipoPet : TipoPet.values()){
                if(tipoPet.getValor().equalsIgnoreCase(valor)){
                    return tipoPet;
                }
            }
        return null;
    }
}
