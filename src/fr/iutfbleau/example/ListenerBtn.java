package fr.iutfbleau.example;

import java.awt.event.*;
import javax.swing.JButton;

/**
 * Classe pour l'ecouteur generique pour les boutons de l'application.
 * Déclenche des actions en fonction de la commande associée au bouton.
 * @author Algassimou Pellel Diallo
 * @version 1.0
 */
public class ListenerBtn implements ActionListener {

    /**
     * Contrôleur de l'application.
     */
    private ControleurRappel controleur;


    /**
     * Construit un écouteur de boutons.
     *
     * @param c le contrôleur de l'application
     */
    public ListenerBtn(ControleurRappel c) {
        this.controleur = c;
    }

    /**
     * Methode de gestion les différentes actions selon le bouton cliqué.
     * Déclenche les actions du contrôleur en fonction de la commande du bouton :
     * ajouter, modifier, retour, détail, vueajouter, suppression.
     *
     * @param e l'événement déclenché par le clic utilisateur
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton btn = (JButton) source;
            String action = btn.getActionCommand();

            if (action.equals("ajouter")) {
                controleur.afficherFormAjout();
            }
            else if (action.equals("modifier")) {
                ModelRappel r = (ModelRappel) btn.getClientProperty("rappel");
                controleur.afficherFormModification(r);
            }
            else if (action.equals("retour")) {
                controleur.afficherListe();
            }
            else if (action.equals("detail")) {
                ModelRappel r = (ModelRappel) btn.getClientProperty("rappel");
                controleur.afficherDetail(r);
            }
            else if(action.equals("vueajouter")){
                controleur.afficherFormAjout();
            }
            else if(action.equals("supression")){
                ModelRappel r = (ModelRappel) btn.getClientProperty("rappel");
                controleur.supprimerRappel(r.getId());
            }
            else {
                // je fais rien
            }
        }
    }
}
