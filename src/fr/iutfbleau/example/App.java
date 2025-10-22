package fr.iutfbleau.example;

import javax.swing.*;

public class App {

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
