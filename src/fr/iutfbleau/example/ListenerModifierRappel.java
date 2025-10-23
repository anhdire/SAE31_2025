package fr.iutfbleau.example;
import java.awt.event.*;

/**
 * Écouteur pour le bouton permettant de modifier un rappel.
 * Affiche le formulaire de modification via le contrôleur.
 * @author Ayoub ANHDIRE, Algassimou Pellel DIALLO , Youness BOULALAM
 * @version 1.0
 */
public class ListenerModifierRappel implements ActionListener {
    /**
     * Contrôleur de l'application.
     */
    private ControleurRappel controleur;

    /**
     * Construit un écouteur de modification de rappel.
     *
     * @param controleur le contrôleur de l'application
     */
    public ListenerModifierRappel(ControleurRappel controleur) {
        this.controleur = controleur;
    }

    /**
     * Affiche le formulaire de modification en réponse à l'action utilisateur.
     * @param e l'événement déclenché par l'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.controleur.afficherFormAjout();
    }
}
