package fr.iutfbleau.example;

import java.awt.*;
import javax.swing.*;

public class VueMainFrame extends JFrame {
    private VueListePanel listePanel;
    private VueRappelAddPanel formPanel;
    private VueDetailPanel detailPanel;
    private CardLayout cardLayout;
    private JPanel container;

    public VueMainFrame() {
        super("Papillon");
        super.setSize(500,500);
        super.setLocation(0,0);
        super.setAlwaysOnTop(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formPanel = new VueRappelAddPanel();
        super.add(formPanel);

    }

    public void showPanel(String name) {
        cardLayout.show(container, name);
        if (name.equals("Liste")) {
            this.setTitle("Liste des rappels");
        } else if (name.equals("Form")) {
            this.setTitle("Ajouter/Modifier un rappel");
        } else if (name.equals("Detail")) {
            this.setTitle("Détails du rappel");
        }

    }
    public VueDetailPanel getDetailPanel() { return detailPanel; }
    public VueListePanel getListePanel() { return listePanel; }
    public VueRappelAddPanel getFormPanel() { return formPanel; }
}
