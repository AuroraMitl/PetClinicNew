package com.aurora.petClinic.model;

public class Cat extends Pet {

    public Cat(String petName) {
        super (petName);
    }

    public Cat(int id){
        super (id);
    }

    @Override
    public String toString() {
        return super.toString() + ", тип: cat.";
    }
}