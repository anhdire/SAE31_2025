package fr.iutfbleau.example;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

/**
 * VueListePanel représente l'écran affichant la liste des rappels.
 * Il contient des cartes pour chaque rappel et un bouton pour en ajouter un nouveau.
 */
public class VueListePanel extends JPanel {

    /** Scroll contenant la liste des rappels */
    private final JScrollPane scrollPane;

    /** Panneau vertical contenant les cartes de rappels */
    private final JPanel listeRappel;

    /** Bouton pour ajouter un rappel */
    private final JButton boutonAjout;

    /** Liste de tous les boutons liés aux rappels (bouton "...") */
    private final List<JButton> boutonsRappels = new java.util.ArrayList<>();

    /**
     * Constructeur : initialise les composants de la vue liste.
     */
    public VueListePanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        // Panneau contenant tous les rappels
        this.listeRappel = new JPanel();
        this.listeRappel.setLayout(new BoxLayout(this.listeRappel, BoxLayout.Y_AXIS));
        this.listeRappel.setBackground(Color.WHITE);

        // Scroll contenant la liste
        this.scrollPane = new JScrollPane(listeRappel);
        this.scrollPane.setBorder(null);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Bouton d'ajout
        this.boutonAjout = new JButton("Ajouter un rappel");
        this.boutonAjout.setActionCommand("vueajouter");
        this.boutonAjout.setFocusPainted(false);
        this.boutonAjout.setFont(new Font("Arial", Font.BOLD, 13));
        this.boutonAjout.setBackground(new Color(0x3A3A3A));
        this.boutonAjout.setForeground(Color.WHITE);
        this.boutonAjout.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 16));
        this.boutonAjout.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel basPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        basPanel.setBackground(Color.WHITE);
        basPanel.add(boutonAjout);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(basPanel, BorderLayout.SOUTH);
    }

    /**
     * Met à jour les cartes affichées avec une nouvelle liste de rappels.
     *
     * @param rappels liste des rappels à afficher
     */
    public void rafraichirListe(List<ModelRappel> rappels) {
        listeRappel.removeAll();
        boutonsRappels.clear();

        if (rappels == null || rappels.isEmpty()) {
            JPanel centerPanel = new JPanel(new GridBagLayout());
            centerPanel.setBackground(Color.WHITE);

            JLabel message = new JLabel("Aucun rappel à afficher.", SwingConstants.CENTER);
            message.setFont(new Font("Arial", Font.BOLD, 16));
            message.setForeground(new Color(255, 165, 0)); // orange

            centerPanel.add(message);
            listeRappel.setLayout(new BorderLayout());
            listeRappel.add(centerPanel, BorderLayout.CENTER);
        } else {
            rappels.sort(new ComparateurRang());
            listeRappel.setLayout(new BoxLayout(listeRappel, BoxLayout.Y_AXIS));

            for (ModelRappel r : rappels) {
                JPanel carte = new JPanel(new BorderLayout());
                carte.setBackground(getCouleurParTheme(r.getTheme()));

                carte.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(220, 220, 220), 1, true),
                    new EmptyBorder(8, 12, 8, 12)
                ));

                // Jai une taille fixe pour le panel du rappel
                Dimension tailleCarte = new Dimension(395, 65);
                carte.setPreferredSize(tailleCarte);
                carte.setMaximumSize(tailleCarte);
                carte.setMinimumSize(tailleCarte);

                // Titre
                JLabel titre = new JLabel(r.getTitre());
                titre.setFont(titre.getFont().deriveFont(Font.BOLD, 14f));

                // Contenu tronqué
                String contenu = r.getContenu();
                if (contenu != null && contenu.length() > 40) {
                    contenu = contenu.substring(0, 40) + "...";
                }
                JLabel contenuLabel = new JLabel("<html><p style='width:250px'>" + contenu + "</p></html>");
                contenuLabel.setFont(new Font("Arial", Font.PLAIN, 12));

                // Panneau texte 
                JPanel textePanel = new JPanel();
                textePanel.setLayout(new BoxLayout(textePanel, BoxLayout.Y_AXIS));
                textePanel.setOpaque(false);
                textePanel.add(titre);
                textePanel.add(Box.createVerticalStrut(10));
                textePanel.add(contenuLabel);

                // Bouton "..."
                JButton btn = new JButton("...");
                btn.setActionCommand("detail");
                btn.putClientProperty("rappel", r);
                btn.setFocusPainted(false);
                btn.setFont(new Font("Arial", Font.BOLD, 15));
                btn.setBackground(new Color(0xCEDBEF));
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.setBorder(BorderFactory.createEmptyBorder());
                Dimension btnSize = new Dimension(30, 30);
                btn.setPreferredSize(btnSize);
                btn.setMaximumSize(btnSize);
                btn.setMinimumSize(btnSize);

                boutonsRappels.add(btn);

                carte.add(textePanel, BorderLayout.CENTER);
                carte.add(btn, BorderLayout.EAST);
                carte.setAlignmentX(Component.LEFT_ALIGNMENT);

                listeRappel.add(carte);
                listeRappel.add(Box.createVerticalStrut(10));
            }
        }

        listeRappel.revalidate();
        listeRappel.repaint();
    }

    /**
     * Retourne une couleur correspondant à un thème donné.
     *
     * @param theme numéro de thème
     * @return couleur associée
     */
    private Color getCouleurParTheme(int theme) {
        if (theme == 1) {
            return new Color(255, 236, 236);  // Rouge
        }
        if (theme == 2) {
            return new Color(255, 249, 230);  // Jaune
        }
        if (theme == 3) {
            return new Color(233, 255, 233);  // Vert
        }
        if (theme == 4) {
            return new Color(230, 240, 255);  // Bleu
        }
        return new Color(240, 240, 240);      // Gris par défaut
    }

    /**
     * Retourne le bouton "Ajouter un rappel".
     * @return bouton d’ajout
     */
    public JButton getButtonAdd() {
        return this.boutonAjout;
    }

    /**
     * Retourne la liste des boutons "..." pour chaque rappel.
     * @return liste de boutons
     */
    public List<JButton> getButtonsRappels() {
        return this.boutonsRappels;
    }
}
