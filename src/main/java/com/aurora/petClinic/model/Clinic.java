package com.aurora.petClinic.model;


import com.aurora.petClinic.ConsoleUI;


import java.util.ArrayList;

public class Clinic {

    private ArrayList<Client> clientsList = new ArrayList<>();

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(ArrayList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public void addClient(Client client) {
        this.clientsList.add(client);
    }

    public void delClient (Client client) {
        this.clientsList.remove(client);
    }

    public Client searchClient(String nameClient) {
        for (Client client : clientsList) {
            if (client.getName().equals(nameClient)) {
                return client;
            }
        }
        return null;
    }
    public void clientListOutput(){
        System.out.println(getClientsList());

    }
}



