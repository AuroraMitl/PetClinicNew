package com.aurora.petClinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ClinicTest extends Clinic{

    void resetClinic() {
        instance = null;
    }

    @Test
    void delClient() {
        Client client1 = new Client("Vasa");
        Client client2 = new Client("Peta");

        ArrayList<Client> expList = new ArrayList<>();
        expList.add(client1);
        expList.add(client2);
        expList.remove(client1);

        resetClinic();
        Clinic clinic = Clinic.getInstance();

        clinic.addClient(client1);
        clinic.addClient(client2);
        clinic.delClient(client1);

        Assertions.assertEquals(expList, clinic.getClientsList());
    }

    @Test
    void searchClientByPet() {
        Client client1 = new Client("Vasa");
        Client client2 = new Client("Peta");
        client1.addPet(new Cat("Tom"));
        client2.addPet(new Dog("Jerry"));

        resetClinic();
        Clinic clinic = Clinic.getInstance();
        clinic.addClient(client1);
        clinic.addClient(client2);

        String petNameForSearch1 = "Tom";
        String petNameForSearch2 = "Jerry";
        String petNameForSearch3 = "Kotopyos";

        Assertions.assertEquals(client1, clinic.searchClientByPet(petNameForSearch1));
        Assertions.assertEquals(client2, clinic.searchClientByPet(petNameForSearch2));
        Assertions.assertNull(clinic.searchClientByPet(petNameForSearch3));
    }
    @Test
    void addClient() {
        Client client1 = new Client("Тирания");
        Client client2 = new Client("Бубоник");
        resetClinic();
        ArrayList<Client> testList = new ArrayList<Client>() {{
add(client1);
add(client2);
        }};
        Clinic clinic=Clinic.getInstance();
        clinic.addClient(client1);
        clinic.addClient(client2);
        Assertions.assertEquals(testList, clinic.getClientsList());
    }
}