package model.enums;

public enum Sexo {

    MACHO("macho"),
    FEMEA("femea");

    private String valor;

    Sexo(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

    public static Sexo sexoPorValor(String valor){

        for(Sexo sexo : Sexo.values()){
            if(sexo.getValor().equalsIgnoreCase(valor)){
                return sexo;
            }
        }
        return null;
    }
}
