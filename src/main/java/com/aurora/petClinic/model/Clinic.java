package com.aurora.petClinic.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Clinic {
  
    protected static Clinic instance;
    protected ArrayList<Client> clientsList = new ArrayList<>();

    protected Clinic() {

    }
  
    public static Clinic getInstance() {

        if(instance == null) {		//если объект еще не создан, то создаем
                instance = new Clinic();	 //создать новый объект, если слишком надо
        }
        return instance;		// вернуть созданный объект
    }

    public ArrayList<Client> getClientsList() {
        return clientsList;
    }

    public ArrayList<Client> sortClientList() {
        clientsList.sort(Comparator.comparing(Client::getName));
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
        return this.clientsList.stream().filter(client -> client.getName().equals(nameClient)).findAny().orElse(null);
    }

    public Client searchClientByPet (String petName) {
        return null;
    }

    public void clientEdit(Client client, String name) {
        client.setName(name);
    }

    public String clientsListToString() {
        StringBuilder clientsListString = new StringBuilder();
        for (Client client : clientsList) {
            clientsListString.append("\n").append(client.toString());
        }
        return clientsListString.toString();
    }


//4. зарефакторить вывод клиентов с петами, чтобы клиенты выводились по человечески и
  //  в алфавитном порядке! а так же петы у клиентов так же чтобы были упорядочены (по типу пускай)


}



