package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database implements AutoCloseable {

    private Connection connection;
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://192.168.1.14:3306/heycha";
    private final String USER = "Ana_Heyzell";
    private final String PASSWORD = "AnaHeyzell8812";

    public Database() {
        try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void checkConnection() throws SQLException {
        try {
            this.getConnection().createStatement();
            System.out.println("La conexión está abierta");
        } catch (SQLException e) {
            System.out.println("La conexión está cerrada");
        }
    }

}
