package fr.iutfbleau.example;

import java.awt.event.*;

/**
 * Écouteur de fermeture pour l'application.
 * Ferme proprement la connexion à la base de données à la fermeture de la fenêtre.
 */
public class ListenerFermeture extends WindowAdapter {

    private DBManager db;

    public ListenerFermeture(DBManager db) {
        this.db = db;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        db.closeConnection();
        System.exit(0);
    }
}
