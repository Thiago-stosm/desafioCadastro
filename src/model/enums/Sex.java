package model.enums;

public enum Sex {
    MALE("male"),
    FEMALE("female");

    private final String description;

    Sex(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
