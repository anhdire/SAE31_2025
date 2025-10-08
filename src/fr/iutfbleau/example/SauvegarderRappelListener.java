package fr.iutfbleau.example;

import java.awt.event.*;

public class SauvegarderRappelListener implements ActionListener {
    private ControleurRappel controller;

    public SauvegarderRappelListener(ControleurRappel c) { this.controller = c; }

    public void actionPerformed(ActionEvent e) { controller.ajouterRappel(null); }
}
