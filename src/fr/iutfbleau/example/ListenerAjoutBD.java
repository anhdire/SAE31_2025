package fr.iutfbleau.example;

import java.awt.event.*;
import javax.swing.*;

public class ListenerAjoutBD implements ActionListener {
    //private static int i = 17;
    private ControleurRappel control;
    private VueMainFrame vmr;

    public ListenerAjoutBD(ControleurRappel cc, VueMainFrame vvv) {
        //i++;
        this.control = cc;
        this.vmr = vvv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().equals("Ajouter ce rappel")) return;

        boolean valide = true;
        String message = "Veuillez corriger les points suivants :\n";

        String titre = vmr.getFormAjoutPanel().getLabel();
        String contenu = vmr.getFormAjoutPanel().getContenu();
        String rankStr = vmr.getFormAjoutPanel().getRank();
        int rang = 0;
        int theme = vmr.getFormAjoutPanel().getThemeChoisi();

        // Vérification titre
        if (titre == null || titre.isEmpty() || titre.equals("Nom : ")) {
            valide = false;
            message += "\t-Le titre du rappel est vide.\n";
        }

        // Vérification rang
        if (rankStr == null || rankStr.isEmpty() || rankStr.equals("Rang : ")) {
            valide = false;
            message += "\t-Le rang doit être renseigné.\n";
        } else {
            try {
                rang = Integer.parseInt(rankStr);
            } catch (NumberFormatException ex) {
                valide = false;
                message += "\t-Le rang doit être un nombre entier.\n";
            }
        }

        // Vérification thème
        if (theme < 1) {
            valide = false;
            message += "\t-Vous devez sélectionner un thème.\n";
        }

        // Si erreur, afficher un seul message
        if (!valide) {
            ErrorManager.showWarning(message);
            return;
        }

        // Sinon, ajouter le rappel
        ModelRappel mr = new ModelRappel(-1, titre, contenu, rang, theme, null);
        control.ajouterRappel(mr);
    }
}
