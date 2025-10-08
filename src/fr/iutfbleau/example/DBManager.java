package fr.iutfbleau.example;
import java.sql.*; // contient Conection, SQLExeption, DriverManager etc ..
public class DBManager {
    private static final String URL = "jdbc:mariadb://dwarves.iut-fbleau.fr/dialloa";
    private static final String LOGIN = "dialloa";
    private static final String MDP = "CAMcode@2025#";
    private Connection connection;

    public DBManager() {
        try {
            this.connection = DriverManager.getConnection(URL, LOGIN, MDP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

    public java.sql.Connection getConnection() { 
        return connection; 
    }


    public void closeConnection() {
        try {
            if (this.connection != null) {
                    this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
