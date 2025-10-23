package fr.iutfbleau.example;

import javax.swing.*;

/**
 * Classe de lancement de l'application "Papillon".
 * Cree Le gestionaire de base de donne,le modele, les vues, le controleur .
 * @author Algassimou Pellel DIALLO , Anhdire Ayoub , Boulalam Youness
 * @version 1.2
 */
public class App {

    /**
    * Méthode main de la classe qui permet de connecter touts les élements puis de les afficher .
    *
    * @param args arguments de la ligne de commande (dans cette SAE , pas besoin)
    */
    
    public static void main(String[] args) {
        DBManager db = new DBManager();
        ModelRappelDAO dao = new ModelRappelDAO(db.getConnection());
        VueMainFrame vue = new VueMainFrame();
        ControleurRappel controleur = new ControleurRappel(dao, vue); // haha

        vue.addWindowListener(new ListenerFermeture(db));
        vue.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        vue.setVisible(true);
    }
}
