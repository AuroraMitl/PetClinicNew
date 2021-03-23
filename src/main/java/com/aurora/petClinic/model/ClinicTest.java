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


}