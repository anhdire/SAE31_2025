package fr.iutfbleau.example;

import java.awt.event.*;


public class ControleurRappel implements ActionListener {
    private VueMainFrame vue;
    private ModelRappelDataBase db;

    public ControleurRappel(ModelRappelDataBase dao, VueMainFrame vue) {
        this.db = dao;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {}

    public void afficherListe() {}
    public void afficherForm(ModelRappel r) {}
    public void afficherDetail(ModelRappel r) {}
    public void ajouterRappel(ModelRappel r) {}
    public void modifierRappel(ModelRappel r) {}
    public void supprimerRappel(int id) {}
    public void chargerTousLesRappels() {}
}
