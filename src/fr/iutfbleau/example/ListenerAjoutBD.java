package fr.iutfbleau.example;

import java.awt.event.*;

/**
 * Écouteur pour le bouton "Ajouter ce rappel".
 * Récupère les données du formulaire, les valide, puis déclenche l'ajout dans la base de données.
 * @author Ayoub ANHDIRE , Diallo Algassimou Pellel , Boulalam Youness
 * @version 1.0
 */
public class ListenerAjoutBD implements ActionListener{

    /** Référence vers le contrôleur principal */
    private ControleurRappel control;

    /** Référence vers la vue principale */
    private VueMainFrame vmr;

    /**
     * Constructeur.
     * @param cc contrôleur à utiliser
     * @param vvv vue principale contenant le formulaire
     */
    public ListenerAjoutBD(ControleurRappel cc, VueMainFrame vvv) {
        this.control = cc;
        this.vmr = vvv;
    }

    /**
     * Méthode appelée lorsqu'un événement est déclenché.
     * Vérifie les données du formulaire, affiche un message si besoin,
     * puis envoie le rappel à enregistrer via le contrôleur.
     * @param e l'événement utilisateur (clic bouton)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().equals("Ajouter ce rappel")) return;

        boolean valide = true;
        String message = "Veuillez corriger les points suivants :\n";

        String titre = vmr.getFormAjoutPanel().getLabel();
        String contenu = vmr.getFormAjoutPanel().getContenu();
  
        int rang = -1;
        int theme = vmr.getFormAjoutPanel().getThemeChoisi();

        // Vérification du titre
        if (titre == null || titre.isEmpty() || titre.equals("Nom : ")) {
            valide = false;
            message += "\t- Le titre du rappel est vide.\n";
        }

        // Vérification du thème
        if (theme < 1) {
            valide = false;
            message += "\t- Vous devez sélectionner un thème.\n";
        }

        // Si erreur, afficher un message et arrêter
        if (!valide) {
            ErrorManager.showWarning(message);
            return;
        }

        // Si tout est valide, créer et ajouter le rappel
        ModelRappel mr = new ModelRappel(-1, titre, contenu, theme, rang, null);
        control.ajouterRappel(mr);
        vmr.getFormAjoutPanel().viderChamps();
    }
}
