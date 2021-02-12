package com.aurora.petClinic.model;

import com.aurora.petClinic.ConsoleUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;



public class Clinic {

   // private static Clinic instance;
   // private ArrayList<Client> clientsList = new ArrayList<>();
    protected static Clinic instance;
Client client;
    protected ArrayList<Client> clientsList = new ArrayList<>();

   // private Clinic() {
    protected Clinic() {

        }
        public void delClient (Client client){
        }

        public Client searchClient (String nameClient){
            for (Client client : clientsList) {
                if (client.getName().equals(nameClient)) {
                    return client;
                }
            }
            return this.clientsList.stream().filter(client -> client.getName().equals(nameClient)).findAny().orElse(null);
        }

        public Client searchClientByPet (String petNameForSearch1) {
            for (Client client : clientsList) {
                for (Pet pet : client.petsList) {
                    if (pet.getPetName().equals(petNameForSearch1)) {
                        return client;
                    }
                }
            }
    return  null;
    }

        public void clientEdit (Client client, String name){
            client.setName(name);
        }
        public String clientsListToString () {
            StringBuilder clientsListString = new StringBuilder();
            for (Client client : clientsList) {
                clientsListString.append("\n").append(client.toString());
            }
            return clientsListString.toString();
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

}



