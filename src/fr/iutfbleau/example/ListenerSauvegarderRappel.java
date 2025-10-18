package fr.iutfbleau.example;

import java.awt.event.*;

public class ListenerSauvegarderRappel implements ActionListener {
    private ControleurRappel controller;
    public ListenerSauvegarderRappel(ControleurRappel controller) {
        this.controller = controller;
    }
   
    public void actionPerformed(ActionEvent e) { 
        controller.ajouterRappel(null); 
    }
}
