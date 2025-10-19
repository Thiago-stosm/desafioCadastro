package model.entities;

import model.enums.PetType;
import model.enums.Sex;

public class Pet {
    private String firstname;
    private String lastname;
    private Sex sex;
    private PetType petType;
    private String address;
    private String district;
    private Integer age;
    private Integer weight;
    private String breed;

    public Pet(String firstname, String lastname, Sex sex, PetType petType, String address, String district, Integer age, Integer weight, String breed) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.petType = petType;
        this.address = address;
        this.district = district;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getDistric() {
        return district;
    }

    public void setDistric(String distric) {
        this.district = distric;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
