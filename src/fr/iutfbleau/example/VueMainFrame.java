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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setTitle("Gestion des rappels");
        this.setLocationRelativeTo(null);
        this.cardLayout = new CardLayout();
        this.container = new JPanel(cardLayout);
        this.listePanel = new VueListePanel();
        this.formPanel = new VueRappelAddPanel();
        this.detailPanel = new VueDetailPanel();
        this.container.add(listePanel, "Liste");
        this.container.add(formPanel, "Form");
        this.container.add(detailPanel, "Detail");
        this.add(container);
        //this.setVisible(true);
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
