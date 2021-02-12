package com.aurora.petClinic;
import com.aurora.petClinic.model.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsoleUI {

    public static void main(String []args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Clinic clinic =  Clinic.getInstance();

        System.out.println("Здравствуйте! Мы рады Вас приветствовать в нашей клинике!");
        boolean flagLayer1 = true;
        while (flagLayer1) {
            System.out.println("\nВведите одну из следующих команд:");
            System.out.println("add_client - добавить нового клиента и его питомца;");
            System.out.println("select_client - выбрать существующего клиента для работы с ним;");
            System.out.println("output - вывести список всех клиентов и их питомцев;");
            System.out.println("exit - завершить работу с программой.");

            String string = bufferedReader.readLine();
            switch (string) {

                case "add_client":
                    System.out.println("Введите имя клиента:");
                    String clientName = bufferedReader.readLine();
                    Client client = new Client(clientName);
                    clinic.addClient(client);
                    System.out.println("Создан клиент " + clientName);
                    System.out.println("Введите кличку животного:");
                    String petName = bufferedReader.readLine();
                    System.out.println("Введите тип питомца : cat, dog");
                    String petType = bufferedReader.readLine();
                    boolean isPetAdded = true;
                    switch (petType.toLowerCase()) {
                        case "cat":
                            Cat catName = new Cat(petName);
                            client.addPet(catName);
                            break;
                        case "dog":
                            Dog dogName = new Dog(petName);
                            client.addPet(dogName);
                            break;
                        default:
                            isPetAdded = false;
                            System.out.println("Неизвестный тип. Добавление животного не произведено.");
                    }
                    if (isPetAdded) {
                        System.out.println("Клиенту " + clientName + " добавлен " + petType + " по кличке " + petName);
                    }
                    //System.out.println("Добавлен клиент " + nameClient + " c " + petType + " " + namePet); //TODO add to SLF4J
                    break;

                case "output":
                    if (clinic.getClientsList().size() > 0) {
                        System.out.println(clinic.clientsListToString());
                    } else {
                        System.out.println("Список клиентов пуст.");
                    }
                    break;

                //output alphabet, checking, commit, why it isnt used??
                case "outputSort":
                    System.out.println(clinic.sortClientList());
                    break;

                case "exit":
                    flagLayer1 = false;
                    System.out.println("До Свидания!");
                    break;

                case "select_selectClientByPet":
                    System.out.println("Введите имя животного:");
                   petName = bufferedReader.readLine();
                   client = clinic.searchClientByPet(petName);
                    System.out.println("\nВыбрано животное " + petName + ".");
                    System.out.println("\nХозяин животного " + client + ".");

                case "select_client":
                    System.out.println("Введите имя клиента:");
                    clientName = bufferedReader.readLine();
                    client = clinic.searchClient(clientName);
                    if (client != null) {
                        boolean flagLayer2 = true;
                        while (flagLayer2) {
                            System.out.println("\nВыбран клиент " + client.getName() + ".");
                            System.out.println("Введите одну из следующих команд:");
                            System.out.println("edit_client - изменить имя клиента;");
                            System.out.println("output - вывести список животных клиента;");
                            System.out.println("add_pet - добавить нового питомца клиенту;");
                            System.out.println("del_pet - удаладить питомца у клиента;");
                            System.out.println("del_client - удалить клиента;");
                            System.out.println("exit - вернуться в главное меню.");
                            string = bufferedReader.readLine();
                            switch (string) {
                                case "edit_client":
                                    System.out.println("Введите новое имя клиента");
                                    String clientNewName = bufferedReader.readLine();
                                    clinic.clientEdit(client, clientNewName);
                                    System.out.println("Имя клиента " + clientName + " изменено на " + clientNewName);
                                    clientName = clientNewName;
                                    break;

                                case "output":
                                    if (client.getPetsList().size() > 0) {
                                        System.out.println(client.petsListToString());
                                    } else {
                                        System.out.println("Список животных пуст.");
                                    }
                                    break;

                                case "add_pet":
                                    System.out.println("Введите кличку питомца:");
                                    petName = bufferedReader.readLine();
                                    System.out.println("Введите тип питомца:");
                                    petType = bufferedReader.readLine();
                                    isPetAdded = true;
                                    switch (petType.toLowerCase()) {
                                        case "cat":
                                            client.addPet(new Cat(petName));
                                            break;
                                        case "dog":
                                            client.addPet(new Dog(petName));
                                            break;
                                        default:
                                            isPetAdded = false;
                                            System.out.println("Неизвестный тип. Добавление животного не произведено.");
                                    }
                                    if (isPetAdded) {
                                        System.out.println("Клиенту " + clientName + " добавлен " + petType + " по кличке " + petName);
                                    }
                                    break;

                                case "del_pet":
                                    System.out.println("Введите кличку питомца:");
                                    petName =  bufferedReader.readLine();
                                    Pet pet = client.searchPet(petName);
                                    if (pet != null) {
                                        client.delPet(pet);
                                        System.out.println("Питомец " + petName + " у клиента " + clientName + " удален.");
                                    } else {
                                        System.out.println("Питомец не найден.");
                                    }
                                    break;

                                case "del_client":
                                    clinic.delClient(client);
                                    System.out.println("Клиент "+clientName+" удален из списка");
                                    flagLayer2 = false;
                                    break;

                                case "exit":
                                    flagLayer2 = false;
                                    break;

                                default:
                                    System.out.println("Мы не поняли что вы имеете ввиду, повторите ввод.");
                            }
                        }
                    } else {
                        System.out.println("Клиента нет в списке.");
                    }
                    break;

                default:
                    System.out.println("Мы не поняли что вы имеете ввиду, повторите ввод.");
            }
        }
    }
}


