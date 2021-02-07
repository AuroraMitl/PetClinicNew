package com.aurora.petClinic.model;

public class Dog extends Pet {

    public Dog(String petName) {
        super (petName);
    }

    public Dog(int id) {
        super (id);
    }

    @Override
    public String toString() {
        return super.toString() + ", тип: dog.";
    }
}