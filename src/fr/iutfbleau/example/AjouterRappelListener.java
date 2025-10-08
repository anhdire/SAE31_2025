package fr.iutfbleau.example;

import java.awt.event.*;

public class AjouterRappelListener implements ActionListener {
    private ControleurRappel controller;

    public AjouterRappelListener(ControleurRappel c) { this.controller = c; }

    public void actionPerformed(ActionEvent e) { controller.afficherForm(null); }
}
