package fr.iutfbleau.example;

import java.awt.event.*;
import javax.swing.JButton;

public class ListenerBtn implements ActionListener {
    private ControleurRappel controleur;

    public ListenerBtn(ControleurRappel c) {
        this.controleur = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton btn) {
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
                System.out.println("Action non reconnue : " + action);
            }
        }
    }
}
