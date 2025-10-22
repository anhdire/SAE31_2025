package fr.iutfbleau.example;
import javax.swing.*;
import java.awt.event.*;

/**
 * Écouteur pour le bouton de modification d'un rappel.
 * Valide les données saisies et met à jour le rappel dans la base de données.
 */
public class ListenerModifieBD implements ActionListener {
	private ControleurRappel c;
	private VueMainFrame v;

	/**
	 * Constructeur du listener.
	 * @param cr le contrôleur de l'application
	 * @param vmn la vue principale
	 */
	public ListenerModifieBD(ControleurRappel cr, VueMainFrame vmn) {
		this.c = cr;
		this.v = vmn;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		int rang=0;
		boolean b = true;
		String mess = "Veuillez corriger les points suivants : \n";

        // 
		if(!e.getActionCommand().equals("Confirmer les modifications")){
			return;
		}

		String newTitle = v.getFormModifPanel().getnewTitle();
		String newwContent = v.getFormModifPanel().getnewContent();
		String newRank = v.getFormModifPanel().getnewRank();
		int newTheme = v.getFormModifPanel().getnewThemeChoisi();

		// Verification du nouveau titre
		if (newTitle == null || newTitle.isEmpty() || newTitle.equals("Nom : ")) {
            b = false;
            mess += "\t- Le titre du rappel est vide.\n";
        }

         // Vérification du rang
        if (newRank == null || newRank.isEmpty() || newRank.equals("Rang : ")) {
            b = false;
            mess += "\t- Le rang doit être renseigné.\n";
        } else {
            try {
                rang = Integer.parseInt(newRank);
            } catch (NumberFormatException ex) {
                b = false;
                mess += "\t- Le rang doit être un nombre entier.\n";
            }
        }

        // Verification du theme 
        if (newTheme < 1) {
            b = false;
            mess += "\t- Vous devez sélectionner un thème.\n";
        }

        // Si erreur, afficher un message et arrêter
        if (!b) {
            ErrorManager.showWarning(mess);
            return;
        }

        // Récupération de l'ID du rappel en cours de modification
        int idRappel = v.getFormModifPanel().getIdRappel();

        // Création du rappel modifié et envoi au contrôleur
        ModelRappel mr = new ModelRappel(idRappel, newTitle, newwContent, newTheme, rang, null);
        c.modifierRappel(mr);
        v.getFormModifPanel().viderChamps();
	}
}