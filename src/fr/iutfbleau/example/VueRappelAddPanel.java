package fr.iutfbleau.example;

import javax.swing.*;

public class VueRappelAddPanel extends JPanel {
    private JTextField titre_add;
    private JTextArea contenu_add;
    private JCheckBox theme_used;
    private JTextField rang;
    private JButton bouton_add;

    public Vue_Rappel_Add() {}

    public ModelRappel getRappelFromForm() { return null; }
    public void remplirChamps(ModelRappel r) {}
    public void viderChamps() {}
}
