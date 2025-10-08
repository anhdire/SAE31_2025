package fr.iutfbleau.example;

import java.awt.*;
import javax.swing.*;

public class VueMainFrame extends JFrame {
    private VueListePanel listePanel;
    private VueRappelAddPanel formPanel;
    private VueDetailPanel detailPanel;
    private CardLayout cardLayout;
    private JPanel container;

    public VueMainFrame() {}

    public void showPanel(String name) {}
    public VueDetailPanel getDetailPanel() { return detailPanel; }
    public VueListePanel getListePanel() { return listePanel; }
    public VueRappelAddPanel getFormPanel() { return formPanel; }
}
