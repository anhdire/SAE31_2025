package fr.iutfbleau.example;
import java.awt.event.*;

public class ListenerModifierRappel implements ActionListener {
    private ControleurRappel controleur;

    public ListenerModifierRappel(ControleurRappel controleur) {
        this.controleur = controleur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controleur.afficherFormAjout();
    }
}
