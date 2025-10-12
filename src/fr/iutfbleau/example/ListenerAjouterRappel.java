package fr.iutfbleau.example;
import java.awt.event.*;

public class ListenerAjouterRappel implements ActionListener {
    public ControleurRappel controleur;

    public ListenerAjouterRappel(ControleurRappel controleur) {
        this.controleur = controleur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Ajouter un rappel")){
            System.out.println("C'est le détecteur d'ajout de rappel");
            this.controleur.afficherFormAjout();
        }
    }
}
