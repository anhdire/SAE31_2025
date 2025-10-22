package fr.iutfbleau.example;
import javax.swing.*;
import java.awt.event.*;



public class ListenerModifieBD implements ActionListener{
	private ControleurRappel c;
	private VueMainFrame v;

	public ListenerModifieBD(ControleurRappel cr,VueMainFrame vmn){
		this.c = cr;
		this.v = vmn;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		int rang=0;
		boolean b = true;
		String mess = "Veuillez corriger les points suivants : \n";
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
      		
        // il faut recuperer l'ancien ID du rappel
        // occupe toi de cela algassimou
        // le reste est opérationnel
        

        //ModelRappel mr = new ModelRappel(,newTitle,newwContent,newTheme,rang,null);
        //c.modifierRappel(mr);
        //v.getFormModifPanel().viderChamps();

	}
}