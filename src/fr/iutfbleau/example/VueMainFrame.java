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
        super.setSize(450,450);
        super.setLocation(0,0);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.formPanel = new VueRappelAddPanel();
        this.listePanel = new VueListePanel();
        this.detailPanel = new VueDetailPanel();

        this.cardLayout = new CardLayout();
        this.container = new JPanel(cardLayout);

        container.add(listePanel, "Liste");
        container.add(formPanel, "Form");
        container.add(detailPanel, "Detail");

        this.add(container);
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
    public VueDetailPanel getDetailPanel() { 
        return detailPanel; 
    }
    public VueListePanel getListePanel() { 
        return listePanel; 
    }
    public VueRappelAddPanel getFormPanel() { 
        return formPanel; 
    }
    public CardLayout getCartes(){
        return this.cardLayout;
    }
    public JPanel getPanel(){
        return this.container;
    }
}
