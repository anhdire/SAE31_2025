package fr.iutfbleau.example;
import java.awt.event.*;

/**
 * Écouteur pour le bouton de modification d'un rappel.
 * Valide les données saisies et met à jour le rappel dans la base de données.
 * @author Ayoub ANHDIRE, Algassimou Pellel DIALLO , Youness BOULALAM
 * @version 1.0
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

    /**
     * Gère l'action de confirmation des modifications.
     * Vérifie les champs, affiche un avertissement en cas d'erreur,
     * et transmet les données modifiées au contrôleur.
     * @param e l'événement déclenché par l'action utilisateur
     */
	@Override
	public void actionPerformed(ActionEvent e){
		boolean b = true;
		String mess = "Veuillez corriger les points suivants : \n";

        // verifier que le bouton correspondant est bien celui de la modification
		if(!e.getActionCommand().equals("Confirmer les modifications")){
			return;
		}

		String newTitle = v.getFormModifPanel().getnewTitle();
		String newContent = v.getFormModifPanel().getnewContent();
		int newTheme = v.getFormModifPanel().getnewThemeChoisi();

		// Verification du nouveau titre
		if (newTitle == null || newTitle.isEmpty() || newTitle.equals("Nom : ")) {
            b = false;
            mess += "\t- Le titre du rappel est vide.\n";
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

        // On récupère le rappel actuel pour garder son rang
		ModelRappel ancien = c.getDao().getOneRappel(idRappel);
		if (ancien == null) {
			ErrorManager.showError("Le rappel sélectionné n'existe plus.");
			return;
		}

		// Création du rappel modifié avec son rang d’origine
		ModelRappel mr = new ModelRappel(
			idRappel,
			newTitle,
			newContent,
			newTheme,
			ancien.getRang(), 
			null
		);
		c.modifierRappel(mr);
		v.getFormModifPanel().viderChamps();
	}
}
