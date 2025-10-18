package fr.iutfbleau.example;

import java.awt.event.*;

import javax.swing.JButton;

public class ListenerVoirDetail implements ActionListener {
    private ControleurRappel controleur;
    public ListenerVoirDetail(ControleurRappel controleur) {
        this.controleur = controleur;
        System.out.println("ListenerVoirDetail créé");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        ModelRappel r = (ModelRappel) source.getClientProperty("rappel");
        this.controleur.afficherDetail(r);
    }
}
