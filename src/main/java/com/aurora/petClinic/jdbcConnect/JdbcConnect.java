package com.aurora.petClinic.jdbcConnect;

import com.aurora.petClinic.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcConnect {
    private static String url = "jdbc:postgresql://10.15.16.1:5432/PetClinic";
    private static String login = "petpguser";
    private static String password = "javasucks";
    // public static final String DB_URL = "jdbc:postgresql://localhost:5432/PetClinic " ;
    public static final String DB_Driver = "org.postgresql.Driver";
    public static void main(String[] args) {
        try {
            Class.forName(DB_Driver);
//Проверяем наличие JDBC драйвера для работы с БД
            Connection connection = DriverManager.getConnection(url, login, password);
//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");
            connection.close();
// отключение от БД
            System.out.println("Отключение от СУБД выполнено.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
// обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace();
// обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
    }

    public static Integer addClient(String clientName) {

        String query = "INSERT INTO clients (name) VALUES(?)";

        try (Connection con = DriverManager.getConnection(url, login, password);



             PreparedStatement preStat = con.prepareStatement((query), new String[] {"client_id"}))  {
            preStat.setString(1, clientName);
            preStat.executeUpdate();
         ResultSet resultSet = preStat.getGeneratedKeys();
            if (resultSet.next()) {
              int clientId = resultSet.getInt("client_id");
               return clientId;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   return -1;
    }

    public static List<Client> getAllClients() throws ClassNotFoundException, SQLException {
        String query = "SELECT name FROM clients";
        List<Client> clientsList=new ArrayList<>();

        Class.forName("org.postresql.Driver");
        try(Connection con=DriverManager.getConnection(url, login, password);
        PreparedStatement preStat=con.prepareStatement(query)){
            ResultSet resultSet=preStat.executeQuery();
        while(resultSet.next()){
            String clientName=resultSet.getString("name");
            clientsList.add(new Client(clientName));
        }
            return clientsList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }







public static void addPet(String petName,String petType,int clientId) {
    //PreparedStatement stmt = con.prepareStatement("INSERT INTO jc_contact (first_name, last_name, phone, email) VALUES (?, ?, ?, ?)", new String[] {"contact_id"});


        String query = "INSERT INTO pets (name,client_id,type) VALUES(?,?,?)";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)){
            preStat.setString(1, petName);
            preStat.setInt(2,   clientId);
            preStat.setString(3,petType);
            preStat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public  static String searchClientByPet (String petNameForSearch){
        String query="SELECT  clients.name FROM clients,pets WHERE clients.client_id = pets.client_id AND pets.name=?";

        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setString(1, petNameForSearch);

            preStat.executeQuery();
            ResultSet resultSet = preStat.getResultSet();
            if (resultSet.next()) {
               String clientName= resultSet.getString("name");

                return clientName;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }



    public static int getClientId(String clientName) {

        String query = "SELECT client_id FROM clients WHERE name= ?";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement((query), new String[] {"client_id"}))  {
            preStat.setString(1, clientName);

            preStat.executeQuery();
            ResultSet resultSet = preStat.getResultSet();
            if (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                return clientId;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   return -1;
    }



    public static void delClient(String clientName) {

        String query = "DELETE FROM clients WHERE (name) VALUES(?)";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setString(1, clientName);
            preStat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


  /*  public void deleteClientFromDB(int client_id) {

        String query = "DELETE FROM clients WHERE client_id = ?";
        try (Connection con = DriverManager.getConnection(url, login, password);
             PreparedStatement preStat = con.prepareStatement(query)) {
            preStat.setInt(1, client_id);
            preStat.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
