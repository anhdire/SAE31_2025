package fr.iutfbleau.example;

import java.awt.event.*;

/**
 * Écouteur de fermeture pour l'application.
 * Ferme proprement la connexion à la base de données à la fermeture de la fenêtre.
 * @author Algassimou Pellel Diallo, ANHDIRE Ayoub , Boulalam Youness
 * @version 1.0
 */
public class ListenerFermeture extends WindowAdapter {

    private DBManager db;

    /**
     *Classe qui permet de fermer la page avec un listener.
     * @param db est utilise pour fermer la connexion à la base de données.
     */
    public ListenerFermeture(DBManager db) {
        this.db = db;
    }

    /**
     * Methode qui est est appelée lors de la fermeture de la vue pour fermer la frame.
     * Elle ferme aussi l'acces à la base de données.
     * @param e l'événement de fermeture de fenêtre.
     */
    
    @Override
    public void windowClosing(WindowEvent e) {
        db.closeConnection();
        System.exit(0);
    }
}
