package org.example.Connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionFactory {
    private static final String USER =
            System.getenv("SQLSERVER_USER");

    private static final String PASSWORD =
            System.getenv("SQLSERVER_PASSWORD");

    //Em Java, constante normalmente fica em MAIÚSCULO
    public static final String CONNECTION_STRING =
            "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=VendasDataBase;" +
                    "encrypt=true;" +
                    "trustServerCertificate=true;";
    public static Connection GetConnection(){
        try{
            return DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
