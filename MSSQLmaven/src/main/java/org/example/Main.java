package org.example;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static String connectionString =
            "jdbc:sqlserver://localhost:1433;" +
                    "database=PD_212;" +
                    "user=PHP;" +
                    "password=111;" +
                    "Connect Timeout=30;Encrypt=True;" +
                    "TrustServerCertificate=True;";
    static Connection connection;

    public static void main(String[] args) {

        System.out.println(connectionString);
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        String query =
                "SELECT " +
                        "FORMATMESSAGE(N'%s %s %s',last_name,first_name,middle_name) AS N'Студент', " +
                        "group_name," +
                        "direction_name " +
                        "FROM Students JOIN Groups ON ([group]=group_id) JOIN Directions ON (direction=direction_id)";
        Select(query);
        Select("SELECT * FROM Directions");
    }

    public static void Select(String query) {
        try {
            Statement statement = connection.createStatement();//Открывает соединение??????/

            ResultSet results = statement.executeQuery(query);
            ResultSetMetaData metaData = results.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.println(metaData.getColumnName(i) + "\t\t" + metaData.getColumnClassName(i));
            }
            System.out.println();
            while (results.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.print(results.getObject(i) + "\t");
                }
                System.out.println();
            }
            results.close();
            //connection.close(); //Если закрыть, то последующие вызовы Select() НЕ будут работать
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
