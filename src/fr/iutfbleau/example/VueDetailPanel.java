package fr.iutfbleau.example;

import javax.swing.*;
import java.awt.*;

public class VueDetailPanel extends JPanel {

    private JLabel titreLabel;
    private JTextArea contenuArea;
    private JLabel dateLabel;

    private JButton btnModifier;
    private JButton btnSupprimer;
    private JButton btnRetour;
    private JButton btnTacheAccomplie;

    public VueDetailPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Haut : bouton retour + titre
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        btnRetour = new JButton("Retour");
        btnRetour.setFocusPainted(false);
        btnRetour.setBackground(Color.BLACK);
        btnRetour.setForeground(Color.WHITE);
        btnRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRetour.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnRetour.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        titreLabel = new JLabel();
        titreLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(btnRetour, BorderLayout.EAST);
        topPanel.add(titreLabel, BorderLayout.CENTER);

        // Zone centrale : contenu
        contenuArea = new JTextArea();
        contenuArea.setEditable(false);
        contenuArea.setLineWrap(true);
        contenuArea.setWrapStyleWord(true);
        contenuArea.setFont(new Font("SansSerif", Font.PLAIN, 15));
        contenuArea.setBackground(new Color(250, 250, 250));
        contenuArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JScrollPane scrollPane = new JScrollPane(contenuArea);
        scrollPane.setBorder(null);

        // Bas : bouton tâche accomplie
        btnTacheAccomplie = new JButton("Tâche accomplie");
        btnTacheAccomplie.setFocusPainted(false);
        btnTacheAccomplie.setBackground(new Color(40, 167, 69));
        btnTacheAccomplie.setForeground(Color.WHITE);
        btnTacheAccomplie.setFont(new Font("SansSerif", Font.BOLD, 15));
        btnTacheAccomplie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTacheAccomplie.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnTacheAccomplie.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Date + boutons modifier/supprimer
        JPanel basPanel = new JPanel(new BorderLayout());
        basPanel.setBackground(Color.WHITE);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("SansSerif", Font.ITALIC, 13));
        dateLabel.setForeground(Color.GRAY);
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(Color.WHITE);

        btnModifier = new JButton("Modifier");
        btnSupprimer = new JButton("Supprimer");

        btnModifier.setFocusPainted(false);
        btnModifier.setActionCommand("supprimer");
        btnModifier.setBackground(Color.BLACK);
        btnModifier.setForeground(Color.WHITE);
        btnModifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnModifier.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnModifier.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        btnSupprimer.setFocusPainted(false);
        btnSupprimer.setBackground(new Color(200, 0, 0)); // rouge foncé
        btnSupprimer.setForeground(Color.WHITE);
        btnSupprimer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSupprimer.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnSupprimer.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        buttonPanel.add(btnModifier);
        buttonPanel.add(btnSupprimer);

        basPanel.add(dateLabel, BorderLayout.WEST);
        basPanel.add(buttonPanel, BorderLayout.EAST);

        // Regroupement du bas
        JPanel zoneBas = new JPanel();
        zoneBas.setLayout(new BoxLayout(zoneBas, BoxLayout.Y_AXIS));
        zoneBas.setBackground(Color.WHITE);

        zoneBas.add(Box.createVerticalStrut(10));
        zoneBas.add(btnTacheAccomplie);
        zoneBas.add(Box.createVerticalStrut(10));
        zoneBas.add(basPanel);

        // Ajout au panneau principal
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(zoneBas, BorderLayout.SOUTH);
    }

    // Affiche un rappel
    public void afficherRappel(ModelRappel r) {
        titreLabel.setText(r.getTitre());
        contenuArea.setText(r.getContenu());
        dateLabel.setText("Créé le : " + r.getDate());
        revalidate();
        repaint();
    }

    // Accès aux boutons
    public JButton getBtnModifier() { return btnModifier; }
    public JButton getBtnSupprimer() { return btnSupprimer; }
    public JButton getBtnRetour() { return btnRetour; }
    public JButton getBtnTacheAccomplie() { return btnTacheAccomplie; }
}
