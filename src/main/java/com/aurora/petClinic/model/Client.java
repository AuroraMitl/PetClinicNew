package com.aurora.petClinic.model;

import java.util.ArrayList;

public class Client {

    private  String name;
    private String petName;

    ArrayList<Pet> petsList = new ArrayList<Pet>();

    public Client() {

    }
    public Client(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public ArrayList<Pet> getPetsList() {
        return petsList;
    }

    public void setPetsList(ArrayList<Pet> petsList) {
        this.petsList=petsList;
    }

    public void addPet(Pet pet) throws NullPointerException {

        this.petsList.add(pet);
    }

    public void delPet (Pet pet) {
        this.petsList.remove(pet);
    }

    public Pet searchPet (String petName) {
        for (Pet pet : petsList) {
            if (pet.getPetName().equals(petName)) {
                return pet;
            }
        }
        return null;
    }



    @Override
    public String toString() {
        return "Client [Хозяин животного=" + name
                + ", список животных=" + petsList + "]";
    }

    public int compareToIgnoreCase(Client s2) {
        return petsList.indexOf(s2);
    }
}



