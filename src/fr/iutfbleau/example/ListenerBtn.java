package fr.iutfbleau.example;

import javax.swing.JButton;
import java.awt.event.*;

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
            else {
                System.out.println("Action non reconnue : " + action);
            }
        }
    }
}
