package model.enums;

public enum PetType {
    DOG("dog"),
    CAT("cat");

    private final String description;

    PetType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
