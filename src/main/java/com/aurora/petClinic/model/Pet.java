package com.aurora.petClinic.model;

/*Создать программу для обслуживания клиники домашних питомцев:
        Должна быть возможно добавлять клиентов.
        Указывать какой питомец есть у клиента.
        Возможность искать по кличке питомца, по имени клиента.
        Редактировать имя клиента, имя питомца.
        Удалять клиента, питомца.

 */
public abstract class Pet {

    private String petName;
    int id;

    public Pet(String petName){
        this.petName=petName;
    }

    public Pet(int id){
        this.id=id;
    }

    public String getPetName() {
        return petName;
    }

    @Override
    public String toString() {
        return "Pet [кличка животного=" + petName
                + "]";
    }

}
