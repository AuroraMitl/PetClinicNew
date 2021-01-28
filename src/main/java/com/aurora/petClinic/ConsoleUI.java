package com.aurora.petClinic;

import com.aurora.petClinic.model.Cat;
import com.aurora.petClinic.model.Client;
import com.aurora.petClinic.model.Clinic;
import com.aurora.petClinic.model.Dog;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleUI {




    public static void main(String []args) throws Exception {

        Clinic clinic = new Clinic();

        // Client client=new Client();

        System.out.println("Здравствуйте! Мы рады Вас приветствовать в нашей клинике!\nЕсли Вы хотите записаться на прием со своим питомцем, то введите команду :");
        boolean flag=true;
        while(flag) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String string = bufferedReader.readLine();
            switch (string){
                case ("exit"):
                    flag=false;
                    System.out.println("До Свидания!");
                    break;


                case ("add_client"):
                    System.out.println("Введите имя клиента: ");
                    String  nameClient = bufferedReader.readLine();
                    Client client=new Client(nameClient);
                    clinic.addClient(client);
                    System.out.println("Введите кличку животного: ");
                    String namePet = bufferedReader.readLine();
                    System.out.println("Введите тип питомца : cat, dog or cow");
                    String petType = bufferedReader.readLine();
                    if (petType.equals("cat")) {
                        Cat catName = new Cat(namePet);
                        client.addPet(catName);
                    } else if (petType.equals("dog")) {
                        Dog dogName = new Dog(namePet);
                        client.addPet(dogName);
                    }
                    flag = true;

                    System.out.println("Добавлен клиент "+nameClient+" c "+ petType+" "+namePet); //TODO add to SLF4J
                    break;


                case "search_client":
                    System.out.println("Введите имя клиента для поиска");
                    client = clinic.searchClient(bufferedReader.readLine());

                    //clinic.searchClient(bufferedReader.readLine());

                    if( client==null){
                        System.out.println("Клиента нет в списке");
                    }
                    else{
                        System.out.println("Клиент есть в списке");
                        System.out.println(client);
                    }

                    break;

                case "output":
                    clinic.clientListOutput();
                    break;

                default:
                    System.out.println("Мы не поняли что вы имеете ввиду");

            }
        }
    }
}

