package model.enums;

public enum Sexo {

    MACHO("Macho"),
    FEMEA("Femea");

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
