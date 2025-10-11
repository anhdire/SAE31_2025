package fr.iutfbleau.example;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;
/*
 *  Identifier ce que chaque rappel doit montrer
 * Chaque rappel affiché doit contenir :
    Titre: lisible, en gras (élément principal)

Contenu: un aperçu tronqué sur 1–2 lignes

Indication visuelle: texte “voir +” ou flèche ➜, aligné à droite

Fond coloré: dépend du theme

Réaction au clic / survol
 *
 */
public class VueListePanel extends JPanel {
    private final JScrollPane scrollPane;
    private final JPanel listeRappel;

    public VueListePanel() {
        // Je configure le layout principal
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Je crée le panneau qui contiendra la liste des rappels
        this.listeRappel = new JPanel();
        this.listeRappel.setLayout(new BoxLayout(this.listeRappel, BoxLayout.Y_AXIS));
        this.listeRappel.setBackground(new Color(0xFFFFFF)); // fond général blanc

        this.scrollPane = new JScrollPane(listeRappel);
        this.add(scrollPane);
    }

    public void rafraichirListe(List<ModelRappel> rappels) {

        // Je vide le contenu actuel
        listeRappel.removeAll();

        // Je verifie que la liste n'est pas nulle ou vide
        if (rappels == null || rappels.isEmpty()) {
            listeRappel.add(new JLabel("Aucun rappel à afficher."));
        } else {
            // Triage en fonction du rang 
            rappels.sort(new ComparateurRang());
            // Pour chaque rappel, je crée un JPanel pour l'afficher
            for (ModelRappel r : rappels) {

                JPanel panneauRappel = new JPanel(new BorderLayout());
                JPanel panneauTitre = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JPanel panneauContenu = new JPanel(new BorderLayout());

                // Titre en gras
                JLabel titre = new JLabel(r.getTitre());
                titre.setFont(titre.getFont().deriveFont(Font.BOLD, 16f));
                panneauTitre.setOpaque(false); // transparent
                panneauTitre.add(titre);

                // Contenu tronqué et voir +
                String contenu = r.getContenu();
                if (contenu.length() > 70) {
                    contenu = contenu.substring(0, 70) + "...";
                }

                JLabel contenuLabel = new JLabel(contenu);
                JLabel voirPlus = new JLabel("Cliquer pour voir +");
                voirPlus.setForeground(new Color(0x5555FF)); // bleu doux
                contenuLabel.setFont(contenuLabel.getFont().deriveFont(Font.PLAIN));

                panneauContenu.setOpaque(false);
                panneauContenu.add(contenuLabel, BorderLayout.WEST);
                panneauContenu.add(voirPlus, BorderLayout.EAST);

                // Assemblage des panneaux
                panneauRappel.add(panneauTitre, BorderLayout.NORTH);
                panneauRappel.add(panneauContenu, BorderLayout.CENTER);

                // Gestion de la couleur de fond selon le theme
                int theme = r.getTheme();
                Color fond;
                if (theme == 1) {
                    fond = new Color(0xFFD6D6); // rouge pastel
                } else if (theme == 2) {
                    fond = new Color(0xFFF5CC); // jaune doux
                } else if (theme == 3) {
                    fond = new Color(0xDFFFD6); // vert pastel
                } else if (theme == 4) {
                    fond = new Color(0xD6E9FF); // bleu clair
                } else {
                    fond = new Color(0xD0F0FD); // cyan doux
                }
                panneauRappel.setBackground(fond);

                //Ajout d'une bordure fine et marge interne
                panneauRappel.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(200, 200, 200), 2, true), // bordure arrondie
                    BorderFactory.createEmptyBorder(10, 15, 10, 15) // marges internes
                ));

                // Ajout du rappel à la liste
                listeRappel.add(panneauRappel);
                listeRappel.add(Box.createVerticalStrut(10)); // espace entre cartes
            }

            // Je demande a swing de rafraichir l'affichage avec les nouveaux composants
            listeRappel.revalidate();  // disposition
            listeRappel.repaint();
        }
    }
}
