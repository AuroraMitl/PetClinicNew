package com.aurora.petClinic.model;


import com.aurora.petClinic.ConsoleUI;


import java.util.ArrayList;

public class Clinic {

    ConsoleUI consoleUI=new ConsoleUI();
    Client client =new Client();

    ArrayList<Client> clientsList = new ArrayList<Client>();

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(ArrayList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public  void addClient(Client client) {
        this.clientsList.add(client);
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



