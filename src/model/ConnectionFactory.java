package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection getConnectin() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/dbveiculo";
            con = DriverManager.getConnection(url, "root", "root");
            System.out.println("Conectado");
        } catch (Exception e) {
            System.err.println("Erro de conexao");
        }
        return con;
    }
}
