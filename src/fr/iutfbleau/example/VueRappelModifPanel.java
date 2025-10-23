package fr.iutfbleau.example;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

/**
 * Vue permettant à l'utilisateur de modifier les données du Rappel
 * @author Ayoub ANHDIRE, DIALLO Algassimou Pellel, BOULALAM Youness
 * @version 1.0
 */

public class VueRappelModifPanel extends JPanel{
    /**
     * Previent à l'utilisateur qu'il va modifier un Rappel existant
    */
    private JLabel modifierRappel; 
    /**
     * permet à l'utilisateur de se souvenir du titre qu'il a deja entré
     * il pourra ainsi soit le changer ou le laisser tel quel
    */
    private JTextField modifierTitle;
    /**
     * permet à l'utilisateur de se souvenir du contenu qu'il a mis (ou pas)
     * il pourra ainsi soit le modifier ou le laisset tel quel
    */
    private JTextArea modifierContent;
    /**
     * Bouton permettant a l'utilisateur de changer de theme 
    */
    private JCheckBox one_color;
    /**
     * Bouton permettant à l'utilisateur de changer de theme 
    */
    private JCheckBox two_color;
    /**
     * Bouton permettant à l'utilisateur de changer de theme 
    */
    private JCheckBox three_color;
    /**
     * Bouton permettant à l'utilisateur de changer de theme 
    */
    private JCheckBox four_color;
    /**
     * Bouton permettant à l'utilisateur de changer de theme 
    */
    private JCheckBox five_color;
    /**
     * Bouton permettant à l'utilisateur de confirmer ses modification
    */
    private JButton confirmModification;
    /**
     * Bouton permettant à l'utilisateur de revenir à la liste des rappels
    */
    private JButton getBacktoHome;
    /**
     * Groupe de boutons pour qu'au maximum un theme soit sélectionné
    */
    private ButtonGroup bg;
    /**
     * ID du rappel en cours de modification
    */
    private int idRappel;

    

    /**
    * Interface graphique pour la modification du Rappel
    * vue permettant à l'utilisateur de pouvoir changer les données de son rappel
    */

    public VueRappelModifPanel(){
        super();
        GridLayout page_gestion = new GridLayout(5,1,0,5);
        super.setLayout(page_gestion);
        Font f = new Font("Arial",Font.BOLD,20);
        Font ff = new Font("Arial",Font.BOLD,13);
        this.modifierRappel = new JLabel("Modifier un Rappel");
        this.modifierRappel.setFont(f);
        this.modifierRappel.setForeground(Color.RED);
        this.modifierRappel.setHorizontalAlignment(JLabel.CENTER);
        this.modifierTitle = new JTextField();
        this.modifierTitle.setFont(ff);
        this.modifierContent = new JTextArea(50,50);
        modifierContent.setLineWrap(true);
        modifierContent.setFont(ff);
        JScrollPane scroll = new JScrollPane(modifierContent);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        super.add(modifierRappel);
        super.add(modifierTitle); 
        super.add(scroll);
        //super.add(modifierRank);
        GridLayout grrrrrr = new GridLayout(1,5,5,5);
        JPanel panel = new JPanel();
        panel.setLayout(grrrrrr);
        this.bg = new ButtonGroup();
        this.one_color = new JCheckBox("Rouge");
        one_color.setActionCommand("1");
        bg.add(one_color);
        this.two_color = new JCheckBox("Jaune");
        two_color.setActionCommand("2");
        bg.add(two_color);
        this.three_color = new JCheckBox("Vert");
        three_color.setActionCommand("3");
        bg.add(three_color);
        this.four_color = new JCheckBox("Bleu");
        four_color.setActionCommand("4");
        bg.add(four_color);
        this.five_color = new JCheckBox("Gris");
        five_color.setActionCommand("5");
        bg.add(five_color);
        panel.add(one_color);panel.add(two_color);panel.add(three_color);panel.add(four_color);panel.add(five_color);
        super.add(panel);
        GridLayout gr = new GridLayout(1,2,5,5);
        JPanel jp = new JPanel();
        jp.setLayout(gr);
        this.confirmModification = new JButton("Confirmer les modifications");
        confirmModification.setBackground(new Color(39,200,245));
        confirmModification.setForeground(Color.WHITE);
        confirmModification.setFont(ff);
        this.getBacktoHome = new JButton("Revenir à l'accueil");
        getBacktoHome.setActionCommand("retour");
        getBacktoHome.setBackground(new Color(0x3A3A3A));
        getBacktoHome.setForeground(Color.WHITE);
        confirmModification.setFont(ff);
        jp.add(confirmModification);
        jp.add(getBacktoHome);
        super.add(jp);
    }

    /**
     * Affiche les détails d'un rappel dans l'interface de modification.
     * Permet à l'utilisateur de voir et modifier les données existantes du rappel.
     * @param r le modèle de rappel contenant les données à afficher
     */

    public void afficherRappelModif(ModelRappel r){
        this.idRappel = r.getId();
        modifierTitle.setText(r.getTitre());
        modifierContent.setText(r.getContenu());
    }

    /**
     * Methode permettant de vider les champs et zone de textes
    */
    public void viderChamps(){
        modifierTitle.setText("");
        modifierContent.setText("");
    }
    /**
     * Methode permettant de récupérer le nouveau theme chosit par l'utilisateur
     * @return int un numero de theme(entre 1 et 5)
    */
    
    public int getnewThemeChoisi() {
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
    /** @return le bouton theme 1 */
    public JCheckBox getT1(){
        return this.one_color;
    }
    /** @return le bouton theme 2 */
    public JCheckBox getT2(){
        return this.two_color;
    }
    /** @return le bouton theme 3 */
    public JCheckBox getT3(){
        return this.three_color;
    }
    /** @return le bouton theme 4 */
    public JCheckBox getT4(){
        return this.four_color;
    }
    /** @return le bouton theme 5 */
    public JCheckBox getT5(){
        return this.five_color;
    }

    /**
     * Bouton de confirmation pour sauvegarder les données dans la BD
     * @return JButton permet de recuperer le bouton
    */
    public JButton getButtonModification(){
        return this.confirmModification;
    }
    /**
     * Bouton permettant de revenir en arrièere
     * @return JButton permet de recuperer le bouton
    */

    public JButton getButtonRetour(){
        return this.getBacktoHome;
    }
    /**
     * Permet de récupérer ce que l'utilisateur écrit : le titre
     * @return String retourne ce qu'il écrit sous forme de chaîne de caractères
    */
    
    public String getnewTitle(){
        return this.modifierTitle.getText();

    }

    /**
     * permet de récupérer ce que l'utilisateur écrit : le contenu
     * @return String retourne ce qu'il écrit sous forme de de chaine de caracteres
    */

    public String getnewContent(){
        return this.modifierContent.getText();
    }

    /**
     * Récupère l'ID du rappel en cours de modification.
     * @return l'identifiant du rappel
    */
    public int getIdRappel() {
        return this.idRappel;
    }

}
