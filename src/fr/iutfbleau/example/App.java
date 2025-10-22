package fr.iutfbleau.example;

import javax.swing.*;

/**
 * Classe de lancement de l'application "Papillon".
 * Cree Le gestionaire de base de donne,le modele, les vues, le controleur .
 */
public class App {

    /**
     *Mathode main de la classe qui permet de connecter touts les elements puis de les afficher .
     *
     * @param args
     */
    public static void main(String[] args) {
        DBManager db = new DBManager();
        ModelRappelDAO dao = new ModelRappelDAO(db.getConnection());
        VueMainFrame vue = new VueMainFrame();
        ControleurRappel controleur = new ControleurRappel(dao, vue);

        vue.addWindowListener(new ListenerFermeture(db));
        vue.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        vue.setVisible(true);
    }
}
