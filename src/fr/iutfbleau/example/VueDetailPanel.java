package fr.iutfbleau.example;

import java.awt.*;
import javax.swing.*;

/**
 * Panel qui affiche les détails d’un rappel sélectionné.
 * Il montre le titre, le contenu, la date de création, le thème, le rang, l'id
 * et propose des boutons pour modifier, supprimer ou revenir.
 * @author Algassimou Pellel Diallo, Anhdire Ayoub,Boulalam Youness
 * @version 1.5
 */
public class VueDetailPanel extends JPanel {

    /** Titre du rappel */
    private JLabel titreLabel;

    /** Contenu du rappel */
    private JTextArea contenuArea;

    /** Date de création du rappel */
    private JLabel dateLabel;

    /** Thème du rappel */
    private JLabel themeLabel;

    /** Rang du rappel */
    private JLabel rangLabel;

    /** Id du rappel */
    private JLabel idLabel;

    /** Bouton pour modifier le rappel */
    private JButton btnModifier;

    /** Bouton pour supprimer le rappel */
    private JButton btnSupprimer;

    /** Bouton pour revenir à la liste */
    private JButton btnRetour;

    /** Bouton pour permettre d'augmenter le rang d'une tache*/
    
    private JButton btnMonter;
    /**
     * Bouton pour permettre de descendre le rang d'une tache
    */
    private JButton btnDescendre;

    /**
     * Constructeur qui initialise tous les éléments graphiques de la vue détail.
    */
    public VueDetailPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Haut : bouton retour + titre
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        btnRetour = new JButton("Retour");
        btnRetour.setActionCommand("retour");
        btnRetour.setFocusPainted(false);
        btnRetour.setBackground(Color.BLACK);
        btnRetour.setForeground(Color.WHITE);
        btnRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRetour.setFont(new Font("Arial", Font.BOLD, 13));
        btnRetour.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        titreLabel = new JLabel();
        titreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(btnRetour, BorderLayout.EAST);
        topPanel.add(titreLabel, BorderLayout.CENTER);

        // Zone centrale : contenu
        contenuArea = new JTextArea();
        contenuArea.setEditable(false);
        contenuArea.setLineWrap(true);
        contenuArea.setWrapStyleWord(true);
        contenuArea.setFont(new Font("Arial", Font.BOLD, 15));
        contenuArea.setBackground(new Color(250, 250, 250));
        contenuArea.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(220, 220, 220)),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JScrollPane scrollPane = new JScrollPane(contenuArea);
        scrollPane.setBorder(null);

        // Bas : bouton tâche monter ==> permet de changer le rang d'un RAPPEL
        btnMonter = new JButton("Monter ⬆");
        btnMonter.setActionCommand("Monter");
        btnMonter.setFocusPainted(false);
        btnMonter.setBackground(new Color(40, 167, 69));
        btnMonter.setForeground(Color.WHITE);
        btnMonter.setFont(new Font("Arial", Font.BOLD, 13));
        btnMonter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMonter.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnMonter.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Haut : bouton tâche descendre ==> permet de changer le rang d'un RAPPEL
        btnDescendre = new JButton("Descendre ⬇");
        btnDescendre.setActionCommand("Descendre");
        btnDescendre.setFocusPainted(false);
        btnDescendre.setBackground(Color.RED);
        btnDescendre.setForeground(Color.WHITE);
        btnDescendre.setFont(new Font("Arial", Font.BOLD, 13));
        btnDescendre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDescendre.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnDescendre.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Labels supplémentaires
        idLabel = new JLabel();
        themeLabel = new JLabel();
        rangLabel = new JLabel();

        idLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        themeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        rangLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.add(idLabel);
        infoPanel.add(themeLabel);
        infoPanel.add(rangLabel);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(infoPanel, BorderLayout.SOUTH);

        // Date + boutons modifier/supprimer
        JPanel basPanel = new JPanel(new BorderLayout());
        basPanel.setBackground(Color.WHITE);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.BOLD, 13));
        dateLabel.setForeground(Color.GRAY);
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(Color.WHITE);

        btnModifier = new JButton("Modifier");
        btnSupprimer = new JButton("Supprimer");

        btnModifier.setActionCommand("modifier");
        btnModifier.setFocusPainted(false);
        btnModifier.setBackground(Color.BLACK);
        btnModifier.setForeground(Color.WHITE);
        btnModifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnModifier.setFont(new Font("Arial", Font.BOLD, 13));
        btnModifier.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        btnSupprimer.setActionCommand("supression");
        btnSupprimer.setFocusPainted(false);
        btnSupprimer.setBackground(new Color(200, 0, 0));
        btnSupprimer.setForeground(Color.WHITE);
        btnSupprimer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSupprimer.setFont(new Font("Arial", Font.BOLD, 13));
        btnSupprimer.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        buttonPanel.add(btnModifier);
        buttonPanel.add(btnSupprimer);

        basPanel.add(dateLabel, BorderLayout.WEST);
        basPanel.add(buttonPanel, BorderLayout.EAST);

        JPanel zoneBas = new JPanel();
        zoneBas.setLayout(new BoxLayout(zoneBas, BoxLayout.Y_AXIS));
        zoneBas.setBackground(Color.WHITE);

        JPanel panneau = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
        panneau.setBackground(Color.WHITE);
        panneau.add(btnMonter);
        panneau.add(btnDescendre);

        zoneBas.add(Box.createVerticalStrut(10));
        //zoneBas.add(btnMonter);
        //zoneBas.add(btnDescendre);
        zoneBas.add(panneau);
        zoneBas.add(Box.createVerticalStrut(10));
        zoneBas.add(basPanel);

        add(topPanel,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
        add(zoneBas,BorderLayout.SOUTH);
    }

    /**
     * Affiche les informations du rappel dans les champs de la vue.
     *
     * @param r Le rappel à afficher
     */
    public void afficherRappel(ModelRappel r) {
        this.btnModifier.putClientProperty("rappel", r);
        this.btnSupprimer.putClientProperty("rappel", r);

        titreLabel.setText(r.getTitre());
        contenuArea.setText(r.getContenu());
        dateLabel.setText("Créé le : " + r.getDate());
        idLabel.setText("ID : " + r.getId());
        rangLabel.setText("Rang : " + r.getRang());
        themeLabel.setText("Thème : " + r.getTheme());

        revalidate();
        repaint();
    }

    public JButton getBtnModifier() { 
        return btnModifier; 
    }
    public JButton getBtnSupprimer() { 
        return btnSupprimer; 
    }
    public JButton getBtnRetour() {
        return btnRetour; 
    }
    public JButton getBtnMonter() { 
        return btnMonter; 
    }
}
