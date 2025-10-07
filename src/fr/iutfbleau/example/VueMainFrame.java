package fr.iutfbleau.example;

import javax.swing.*;
import java.awt.*;

public class VueMainFrame extends JFrame {
    private VueListePanel listePanel;
    private Vue_Rappel_Add formPanel;
    private VueDetailPanel detailPanel;
    private CardLayout cardLayout;
    private JPanel container;

    public VueMainFrame() {}

    public void showPanel(String name) {}
    public VueDetailPanel getDetailPanel() { return detailPanel; }
    public VueListePanel getListePanel() { return listePanel; }
    public Vue_Rappel_Add getFormPanel() { return formPanel; }
}
