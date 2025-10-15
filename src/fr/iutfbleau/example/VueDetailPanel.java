package fr.iutfbleau.example;

import javax.swing.*;
import java.awt.*;
public class VueDetailPanel extends JPanel {

    
    /**
     * Construit le panel de détail.
     */
    public VueDetailPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
    }

    public void afficherRappel(ModelRappel r) {
        this.removeAll();
        this.add(new JLabel("Détail du rappel : " + r.getTitre()));
        this.add(new JLabel("Description : " + r.getContenu()));
        this.add(new JLabel("Date : " + r.getDate()));
        this.revalidate();
        this.repaint();
    }
}

