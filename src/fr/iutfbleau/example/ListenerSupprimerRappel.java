package fr.iutfbleau.example;

import java.awt.event.*;

public class ListenerSupprimerRappel implements ActionListener {
    private ControleurRappel controleur;

    public ListenerSupprimerRappel(ControleurRappel controleur) {
        this.controleur = controleur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Supprimer")){
           controleur.supprimerRappel(0);
        }
    }
}
