package fr.iutfbleau.example;


import javax.swing.*;
import java.awt.*;
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
    private final JPanel panelListe;

    public VueListePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.panelListe = new JPanel();
        this.panelListe.setLayout(new BoxLayout(this.panelListe, BoxLayout.Y_AXIS));
        this.scrollPane = new JScrollPane(panelListe);
        this.add(scrollPane);

    }

    public void rafraichirListe(List<ModelRappel> rappels) {
        // Je vide le contenu actuel
        panelListe.removeAll();
        // Je verifie que la liste n'est pas nulle ou vide
        if (rappels == null || rappels.isEmpty()){
            panelListe.add(new JLabel("Aucun rappel à afficher."));
        }else{
            // Pour chaque rappel, je crée un JPanel pour l'afficher
            for (ModelRappel r : rappels){
                JPanel rappel = new JPanel(new BorderLayout());
                JLabel titre = new JLabel(r.getTitre());
                titre.setFont(titre.getFont().deriveFont(Font.BOLD));
                rappel.add(titre, BorderLayout.NORTH);

            }
        }
    }
}
