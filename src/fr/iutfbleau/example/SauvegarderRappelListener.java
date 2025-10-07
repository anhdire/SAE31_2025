package fr.iutfbleau.example;

import java.awt.event.*;

public class SauvegarderRappelListener implements ActionListener {
    private ControlRappel controller;

    public SauvegarderRappelListener(ControlRappel c) { this.controller = c; }

    public void actionPerformed(ActionEvent e) { controller.ajouterRappel(null); }
}
