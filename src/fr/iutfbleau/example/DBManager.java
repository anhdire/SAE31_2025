package fr.iutfbleau.example;

import java.sql.*;

/**
 * Gère la connexion à la base de données.
 * @author Algassimou Pellel Diallo, Anhdire Ayoub, Boulalam Youness
 * @version 1.0
 */
public class DBManager {

    /** URL de connexion à la base de données */
    private static final String URL = "jdbc:mariadb://dwarves.iut-fbleau.fr/boulalam";

    /** Identifiants de connexion */
    private static final String LOGIN = "boulalam";
    private static final String MDP = "azerty";

    /** Nom du driver JDBC */
    public static final String DRIVER = "org.mariadb.jdbc.DRIVER";

    /** Nom de la table utilisée */
    public static final String TABLE_NAME = "SAE31_2025_Rappel";

    /** Connexion à la base de données */
    private Connection connection;

    /**
     * Constructeur qui établit la connexion à la base.
     */
    public DBManager() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, LOGIN, MDP);
        } catch (ClassNotFoundException e) {
            ErrorManager.showError("Erreur lors du chargement du pilote de base de données.");
        } catch (SQLException e) {
            ErrorManager.showError("Impossible de se connecter à la base de données.\nVeuillez vérifier votre connexion ou réessayer plus tard.");
        }
    }

    /**
     * Retourne la connexion à la base de données.
     * @return la connexion
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Ferme proprement la connexion.
     */
    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de la fermeture de la connexion.");
        }
    }
}
