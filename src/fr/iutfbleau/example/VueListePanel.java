package fr.iutfbleau.example;


import javax.swing.*;
import java.util.List;

public class VueListePanel extends JPanel {
    private JScrollPane scrollPane;
    private JPanel panelContenu;

    public VueListePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.panelContenu = new JPanel();
        this.panelContenu.setLayout(new BoxLayout(this.panelContenu, BoxLayout.Y_AXIS));
        this.scrollPane = new JScrollPane(panelContenu);
        this.add(scrollPane);
    }

    public void rafraichirListe(List<ModelRappel> rappels) {
        //super.removeAll();
    }
}
