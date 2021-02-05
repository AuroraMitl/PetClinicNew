package com.aurora.petClinic.model;

import com.aurora.petClinic.ConsoleUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Clinic {
  
    private static Clinic instance;
    private ArrayList<Client> clientsList = new ArrayList<>();

    private Clinic() {

    }
  
    public static Clinic getInstance() {

        if(instance == null){		//если объект еще не создан, то создаем
                instance = new Clinic();	//создать новый объект, если слишком надо
            }
            return instance;		// вернуть созданный объект
        }

    public ArrayList<Client> getClientsList() {

      return clientsList;
    }

    public ArrayList<Client> sortClientList() {
        clientsList.sort(Comparator.comparing(Client::getName));
       // System.out.println(clientsList);

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

    public void clientListOutput() {
        System.out.println(getClientsList());

    }

    public Boolean clientEdit(String name, String newName) {
        for (Client client : clientsList) {

            if (client.getName().equals(name)) {// если имя клиента равно тому, которое получено, то заменяем имя на новое
               client.setName(newName);
                return true;
            }
        }
        return null;

    }


//4. зарефакторить вывод клиентов с петами, чтобы клиенты выводились по человечески и
  //  в алфавитном порядке! а так же петы у клиентов так же чтобы были упорядочены (по типу пускай)


}



