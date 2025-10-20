package fr.iutfbleau.example;
import java.awt.*;
import javax.swing.*;

/**
 * Panneau permettant d'ajouter un nouveau rappel.
 * Contient des champs pour le nom, le contenu, le rang et le thème.
 * Fournit également les boutons pour valider ou revenir en arrière.
 * 
 * @author Toi :)
 * @version 1.0
 */
public class VueRappelAddPanel extends JPanel {

    private JLabel etiquette_add;
    private JLabel etiquette_add_title;
    private JLabel etiquette_add_content;
    private JLabel etiquette_add_rank;
    private JTextField titre_add;
    private JTextArea contenu_add;
    private JTextField rang;

    private JLabel etiquette_theme;
    private JCheckBox theme_used_1; 
    private JCheckBox theme_used_2; 
    private JCheckBox theme_used_3; 
    private JCheckBox theme_used_4;
    private JCheckBox theme_used_5;
    private ButtonGroup bg;

    private JButton bouton_add;
    private JButton bouton_retour;

    private GridLayout gestionnaire_mise_page;

    /**
     * Constructeur du panneau d'ajout.
     * Initialise les composants graphiques et met en page le formulaire.
     */
    public VueRappelAddPanel() {
        super();

        // Configuration de la mise en page
        Font f = new Font("SansSerif", Font.BOLD, 22); 
        this.gestionnaire_mise_page = new GridLayout(10, 1, 0, 2);
        super.setLayout(gestionnaire_mise_page);

        // Titre principal
        this.etiquette_add = new JLabel("                      Ajouter un rappel");
        etiquette_add.setForeground(Color.RED);
        etiquette_add.setFont(f);

        // Champ Nom 
        this.etiquette_add_title = new JLabel("Nom : ");
        this.titre_add = new JTextField(10);

        // Champ Contenu
        this.etiquette_add_content = new JLabel("Contenu :");
        this.contenu_add = new JTextArea(50, 50); 
        contenu_add.setLineWrap(true); 
        JScrollPane jsp = new JScrollPane(contenu_add);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Choix du thème 
        this.etiquette_theme = new JLabel("Thème : ");
        JPanel jp = new JPanel(new GridLayout(1, 5, 3, 0));

        this.theme_used_1 = new JCheckBox("Rouge");
        this.theme_used_1.setActionCommand("1");

        this.theme_used_2 = new JCheckBox("Jaune");
        this.theme_used_2.setActionCommand("2");

        this.theme_used_3 = new JCheckBox("Vert");
        this.theme_used_3.setActionCommand("3");

        this.theme_used_4 = new JCheckBox("Bleu");
        this.theme_used_4.setActionCommand("4");

        this.theme_used_5 = new JCheckBox("Gris");
        this.theme_used_5.setActionCommand("5");

        // Regroupement des cases à cocher pour qu'une seule soit sélectionnable
        this.bg = new ButtonGroup();
        bg.add(theme_used_1);
        bg.add(theme_used_2);
        bg.add(theme_used_3);
        bg.add(theme_used_4);
        bg.add(theme_used_5);

        jp.add(theme_used_1);
        jp.add(theme_used_2);
        jp.add(theme_used_3);
        jp.add(theme_used_4);
        jp.add(theme_used_5);

        // Champ Rang 
        this.etiquette_add_rank = new JLabel("Rang : ");
        this.rang = new JTextField(10);

        // Boutons Ajouter / Retour 
        JPanel jpp = new JPanel();
        jpp.setLayout(new GridLayout(1, 2, 5, 0));

        this.bouton_add = new JButton("Ajouter ce rappel");
        bouton_add.setBackground(new Color(94, 105, 242));

        this.bouton_retour = new JButton("Retour");
        bouton_retour.setActionCommand("retour");

        jpp.add(bouton_add);
        jpp.add(bouton_retour);

        // Assemblage final
        super.add(etiquette_add);
        super.add(etiquette_add_title);
        super.add(titre_add);
        super.add(etiquette_add_content);
        super.add(jsp);
        super.add(etiquette_theme);
        super.add(jp);
        super.add(etiquette_add_rank);
        super.add(rang);
        super.add(jpp);
    }

    /** Efface tous les champs du formulaire. */
    public void viderChamps() {
        this.bg.clearSelection();
        this.titre_add.setText("");
        this.contenu_add.setText("");
        this.rang.setText("");
        super.setBackground(Color.WHITE);
    }

    /**
     * Retourne le numéro du thème sélectionné via les cases à cocher.
     * @return Le numéro de thème choisi (1 à 5), ou 0 si aucun n'est sélectionné ou si erreur.
     */
    public int getThemeChoisi() {
        ButtonModel selected = this.bg.getSelection();
        if (selected == null) {
            return 0;
        }

        String actionCommand = selected.getActionCommand();
        try {
            int valeur = Integer.parseInt(actionCommand);
            return valeur;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /** @return Le bouton "Ajouter ce rappel". */
    public JButton getButton() {
        return this.bouton_add;
    }

    /** @return Le bouton "Retour". */
    public JButton getButtonBack() {
        return this.bouton_retour;
    }

    /** @return Le texte du champ "Nom". */
    public String getLabel() {
        return titre_add.getText();
    }

    /** @return Le contenu saisi dans la zone de texte. */
    public String getContenu() {
        return contenu_add.getText();
    }

    /** 
     * @return La valeur du rang saisi sous forme de texte. 
     * (Affiche aussi la valeur dans la console pour débogage.)
     */
    public String getRank() {
        System.out.println("Theme : " + theme_used_1.getText());
        return rang.getText();
    }

    /** @return Le groupe de boutons des thèmes. */
    public ButtonGroup getGroupeButton() {
        return this.bg;
    }

    public JCheckBox getTheme1() { 
        return theme_used_1; 
    }
    public JCheckBox getTheme2() { 
        return theme_used_2; 
    }
    public JCheckBox getTheme3() { 
        return theme_used_3; 
    }
    public JCheckBox getTheme4() { 
        return theme_used_4; 
    }
    public JCheckBox getTheme5() { 
        return theme_used_5; 
    }
}
