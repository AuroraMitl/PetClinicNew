package com.aurora.petClinic;

import com.aurora.petClinic.model.Cat;
import com.aurora.petClinic.model.Client;
import com.aurora.petClinic.model.Clinic;
import com.aurora.petClinic.model.Dog;

import javax.lang.model.util.Types;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleUI {





    public static void main(String []args) throws Exception {
        Clinic clinic =  Clinic.getInstance();

        System.out.println(clinic);

        System.out.println("Здравствуйте! Мы рады Вас приветствовать в нашей клинике!\nЕсли Вы хотите записаться на прием со своим питомцем, то введите команду :");
        boolean flag=true;
        while(flag) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String string = bufferedReader.readLine();
            switch (string) {
                case ("exit"):
                    flag = false;
                    System.out.println("До Свидания!");
                    break;


                case ("add_client"):
                    System.out.println("Введите имя клиента: ");
                    String nameClient = bufferedReader.readLine();
                    Client client = new Client(nameClient);
                    clinic.addClient(client);
                    System.out.println("Введите кличку животного: ");
                    String namePet = bufferedReader.readLine();
                    System.out.println("Введите тип питомца : cat, dog ");
                    String petType = bufferedReader.readLine();
                    if (petType.equals("cat")) {
                        Cat catName = new Cat(namePet);
                        client.addPet(catName);
                    } else if (petType.equals("dog")) {
                        Dog dogName = new Dog(namePet);
                        client.addPet(dogName);
                    }
                    flag = true;

                    System.out.println("Добавлен клиент " + nameClient + " c " + petType + " " + namePet); //TODO add to SLF4J
                    break;


                case "search_client":
                    System.out.println("Введите имя клиента для поиска");
                    client = clinic.searchClient(bufferedReader.readLine());
                    if (client == null) {
                        System.out.println("Клиента нет в списке");
                    } else {
                        System.out.println("Клиент есть в списке");
                        System.out.println(client);
                    }

                    break;
                //4. зарефакторить вывод клиентов с петами, чтобы клиенты выводились по человечески
                // и в алфавитном порядке! а так же петы у клиентов так же чтобы были упорядочены (по типу пускай)


                case "output":
                    clinic.clientListOutput();

                    break;

                case "outputSort":


                    System.out.println(clinic.sortClientList());
                    break;

// 2. редактирование имени существующего клиента

                case "edit_client":

                    System.out.println("Введите имя клиента для редактирования");
                    String name = bufferedReader.readLine();
                   System.out.println("Введите новое имя клиента");
                    String newName = bufferedReader.readLine();
                    boolean result = clinic.clientEdit(name, newName);
                    if (result = false) {
                        System.out.println(result + "Данного клиента не найдено в базе, смена имени не произведена");
                    }
                    else System.out.println("Имя клиента" + name + "изменено на " + newName);
            break;

            default:
                System.out.println("Мы не поняли что вы имеете ввиду");
        }
        }
            }
        }


