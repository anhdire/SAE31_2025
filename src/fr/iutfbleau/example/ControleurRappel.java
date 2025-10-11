package fr.iutfbleau.example;

import java.awt.event.*;


public class ControleurRappel implements ActionListener {
    private VueMainFrame vue;
    private ModelRappelDAO db;

    public ControleurRappel(ModelRappelDAO dao, VueMainFrame vue) {
        this.db = dao;
        this.vue = vue;
        this.afficherListe();
    }

    public void actionPerformed(ActionEvent e) {}

    public void afficherListe() {
        //System.out.println("Debug");
        vue.getListePanel().rafraichirListe(db.getAllRappels());
        vue.showPanel("Liste");
    }
    public void afficherForm(ModelRappel r) {
        if (r != null) {
            vue.getFormPanel().remplirChamps(r);
        } else {
            vue.getFormPanel().viderChamps();
        }
        vue.showPanel("Form");
    }
    public void afficherDetail(ModelRappel r) {
        vue.getDetailPanel().afficherRappel(r);
        vue.showPanel("Detail");
    }
    public void ajouterRappel(ModelRappel r) {}
    public void modifierRappel(ModelRappel r) {}
    public void supprimerRappel(int id) {}
    public void chargerTousLesRappels() {}
}
