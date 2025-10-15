package fr.iutfbleau.example;
import java.awt.event.*;

public class ListenerAjouterRappel implements ActionListener {
    private ControleurRappel controleur;

    public ListenerAjouterRappel(ControleurRappel controleur) {
        this.controleur = controleur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controleur.afficherFormAjout();
    }
}
