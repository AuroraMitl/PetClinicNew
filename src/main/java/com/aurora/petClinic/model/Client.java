package com.aurora.petClinic.model;

import java.util.ArrayList;

public class Client {

    private  String name;
    private ArrayList<Pet> petsList = new ArrayList<>();

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    void setName(String name){
        this.name=name;
    }

    public ArrayList<Pet> getPetsList() {
        return petsList;
    }

    public void setPetsList(ArrayList<Pet> petsList) {
        this.petsList=petsList;
    }

    public void addPet(Pet pet) {
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

    public String petsListToString() {
        StringBuilder stringPetsList = new StringBuilder();
        for (Pet pet : petsList) {
            stringPetsList.append("\n").append(pet.toString());
        }
        return stringPetsList.toString();
    }

    private String petsListToString(String prefix) {
        StringBuilder stringPetsList = new StringBuilder();
        for (Pet pet : petsList) {
            stringPetsList.append("\n").append(prefix).append(pet.toString());
        }
        return stringPetsList.toString();
    }

    @Override
    public String toString() {
        if (petsList.size() > 0) {
            return "Клиент " + name + ". Животные:" + petsListToString("    ");
        } else {
            return "Клиент " + name + ". Животных нет.";
        }
    }

    public int compareToIgnoreCase(Client s2) {
        return petsList.indexOf(s2);
    }
}



