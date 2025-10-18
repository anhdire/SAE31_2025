package fr.iutfbleau.example;
import java.awt.event.*;

public class ListenerRetourListe implements ActionListener {

    private ControleurRappel controleur;

    public ListenerRetourListe(ControleurRappel controleur) {
        this.controleur = controleur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Retour")){
           controleur.afficherListe();
        }
    }
}