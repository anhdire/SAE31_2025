package fr.iutfbleau.example;

import java.sql.*; // contient Connection, SQLException, DriverManager, etc.

public class DBManager {

    private static final String URL = "jdbc:mariadb://dwarves.iut-fbleau.fr/boulalam";
    private static final String LOGIN = "boulalam";
    private static final String MDP = "azerty";
    public static final String DRIVER = "org.mariadb.jdbc.DRIVER";
    public static final String TABLE_NAME = "SAE31_2025_Rappel";
    private Connection connection;

    public DBManager() {
        try {
            // Ligne pas tre important sur certain environement
            Class.forName("org.mariadb.jdbc.Driver");
      
            this.connection = DriverManager.getConnection(URL, LOGIN, MDP);
            System.out.println("Connexion établie avec la base de données.");
    
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote JDBC MariaDB non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données !");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Connexion fermée proprement.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
