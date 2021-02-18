package com.aurora.petClinic.jdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/PetClinic " ;
    public static final String DB_Driver = "D.learning.PetClinic.lib.";

    public static void main(String[] args) {
        try {
            Class.forName(DB_Driver);
//Проверяем наличие JDBC драйвера для работы с БД

            Connection connection = DriverManager.getConnection(DB_URL);
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

}
