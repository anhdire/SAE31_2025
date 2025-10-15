package fr.iutfbleau.example;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel affichant la liste des rappels.
 * Affiche des "cartes" pour chaque rappel et fournit un bouton pour ajouter un rappel.
 */
public class VueListePanel extends JPanel {
    /** Scroll contenant la liste de cartes. */
    private final JScrollPane scrollPane;
    /** Panneau vertical qui contient les cartes de rappels. */
    private final JPanel listeRappel;
    /** Bouton pour ajouter un nouveau rappel. */
    private final JButton boutonAjout;
    /** Liste de boutons pour chaque rappel. */
    private final List<JButton> boutonsRappels = new java.util.ArrayList<>();

    /**
     * Construit le panel de liste et initialise les composants graphiques.
     */
    public VueListePanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        // Panneau contenant tous les rappels
        this.listeRappel = new JPanel();
        this.listeRappel.setLayout(new BoxLayout(this.listeRappel, BoxLayout.Y_AXIS));
        this.listeRappel.setBackground(Color.WHITE);

        this.scrollPane = new JScrollPane(listeRappel);
        this.scrollPane.setBorder(null);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // masquer les barres (ne plus afficher)
        //this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);



        this.add(scrollPane, BorderLayout.CENTER);

        // Bouton d'ajout "+"
        this.boutonAjout = new JButton("+");
        boutonAjout.setFont(new Font("Arial", Font.BOLD, 19));
        boutonAjout.setPreferredSize(new Dimension(35, 35));
        boutonAjout.setFocusPainted(false);
        boutonAjout.setBackground(new Color(0x007BFF));
        boutonAjout.setForeground(Color.WHITE);
        boutonAjout.setBorder(BorderFactory.createEmptyBorder());
        boutonAjout.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // un JLayeredPane pour superposer le bouton au scrolloane
        JLayeredPane layered = new JLayeredPane();
        this.setPreferredSize(new Dimension(VueMainFrame.WIDTH, VueMainFrame.HEIGHT));
        layered.setLayout(null);
    
        // scrollPane prend tout l'espace
        scrollPane.setBounds(0, 0, VueMainFrame.WIDTH, VueMainFrame.HEIGHT);
        layered.add(scrollPane, JLayeredPane.DEFAULT_LAYER); // DEFAULT_LAYER = 0 (plus bas)

        // je positionne le bouton en bas à droite (marge 12px)
        Dimension b = boutonAjout.getPreferredSize();
        int bx = VueMainFrame.WIDTH - b.width - 45;
        int by = VueMainFrame.HEIGHT - b.height - 55;
        boutonAjout.setBounds(bx, by, b.width, b.height); 
        layered.add(boutonAjout, JLayeredPane.PALETTE_LAYER); // PALETTE_LAYER = 100 (plus haut)

        
        // Ajouter le layeredPane au panel principal
        this.removeAll(); // au cas où il y avait déjà quelque chose
        this.setLayout(new BorderLayout());
        this.add(layered, BorderLayout.CENTER);

    }

    /**
     * Met à jour la liste affichée avec les rappels fournis.
     *
     * @param rappels liste de ModelRappel à afficher (peut être null ou vide)
     */
    public void rafraichirListe(List<ModelRappel> rappels) {
        listeRappel.removeAll();

        if (rappels == null || rappels.isEmpty()) {
            listeRappel.add(new JLabel("Aucun rappel à afficher."));
        } else {
            rappels.sort(new ComparateurRang());

            for (ModelRappel r : rappels) {
                JPanel carteDeRappel = new JPanel(new BorderLayout());
                carteDeRappel.setBackground(getCouleurParTheme(r.getTheme()));
                //ajout bordure arrondie et aussi d'un padding
                carteDeRappel.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(220, 220, 220), 1, true),
                        new EmptyBorder(8, 12, 8, 12)
                ));
                carteDeRappel.setMaximumSize(new Dimension(450, Integer.MAX_VALUE)); // largeur fixe

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
                textePanel.add(Box.createVerticalStrut(5));
                textePanel.add(contenuLabel);

                // Bouton "..."
                JButton boutonAction = new JButton("...");
                this.boutonsRappels.add(boutonAction);
                boutonAction.putClientProperty("rappel", r);  // on Fait porter le rappel par le bouton
                boutonAction.setPreferredSize(new Dimension(20, 20));
                boutonAction.setFocusPainted(false);
                boutonAction.setFont(new Font("Arial", Font.BOLD, 10));
                boutonAction.setBackground(new Color(245, 245, 245));
                boutonAction.setCursor(new Cursor(Cursor.HAND_CURSOR));
                boutonAction.setBorder(BorderFactory.createEmptyBorder());



                carteDeRappel.add(textePanel, BorderLayout.CENTER);
                carteDeRappel.add(boutonAction, BorderLayout.EAST);
                carteDeRappel.setAlignmentX(Component.LEFT_ALIGNMENT);

                listeRappel.add(carteDeRappel);
                listeRappel.add(Box.createVerticalStrut(10));
            }
        }

        listeRappel.revalidate();
        listeRappel.repaint();
    }

    /**
     * Retourne une couleur selon le thème.
     *
     * @param theme identifiant numérique du thème
     * @return couleur de fond correspondante
     */
    private Color getCouleurParTheme(int theme) {
       if (theme == 1) {
            return new Color(0xFFECEC); // rouge 
        } else if (theme == 2) {
            return new Color(0xFFF9E6); // jaune 
        } else if (theme == 3) {
            return new Color(0xE9FFE9); // vert
        } else if (theme == 4) {
            return new Color(0xE6F0FF); // bleu 
        } else {
            return new Color(0xF0F0F0); // gris
        }
    }

    /**
     * Donne accès au bouton d'ajout pour attacher un listener.
     *
     * @return bouton d'ajout
     */
    public JButton getButtonAdd() {
        return this.boutonAjout;
    }

    /**
     * Donne accès à la liste des boutons de rappels pour attacher des listeners.
     *
     * @return liste des boutons de rappels
     */
    public List<JButton> getButtonsRappels() {
        return this.boutonsRappels;
    }
}
