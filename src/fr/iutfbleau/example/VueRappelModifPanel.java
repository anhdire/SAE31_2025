package fr.iutfbleau.example;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

/**
 * Vue permettant à l'utilisateur de modifier les données du Rappel
 * @author Ayoub ANHDIRE
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
     * permet à l'utilisateur de se souvenir du rang qu'il a mis
     * il pourra ainsi le changer selon si ce rang a changé au cours du temps
     * est ce qu'il est devenu plus important ou au contraire a perdu en importance au cours du temps
    */
    private JTextField modifierRank;
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
     * Interface graphique pour la modification du Rappel
    */

    public VueRappelModifPanel(){
        super();
        GridLayout page_gestion = new GridLayout(6,1,0,5);
        super.setLayout(page_gestion);
        Font f = new Font("Garamond",Font.PLAIN,25);
        this.modifierRappel = new JLabel("Modifier un Rappel");
        this.modifierRappel.setFont(f);
        this.modifierRappel.setForeground(Color.RED);
        this.modifierRappel.setHorizontalAlignment(JLabel.CENTER);
        this.modifierTitle = new JTextField();
        this.modifierContent = new JTextArea(50,50);
        modifierContent.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(modifierContent);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.modifierRank = new JTextField();
        super.add(modifierRappel);
        super.add(modifierTitle); 
        super.add(scroll);
        super.add(modifierRank);
        GridLayout grrrrrr = new GridLayout(1,5,5,5);
        JPanel panel = new JPanel();
        panel.setLayout(grrrrrr);
        ButtonGroup bg = new ButtonGroup();
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
        confirmModification.setFont(new Font("Merriweather",Font.PLAIN,14));
        confirmModification.setBackground(new Color(39,245,173));
        this.getBacktoHome = new JButton("Revenir à l'accueil");
        getBacktoHome.setActionCommand("retour");
        getBacktoHome.setFont(new Font("Open Sans",Font.PLAIN,14));
        getBacktoHome.setBackground(new Color(237,69,90));
        jp.add(confirmModification);
        jp.add(getBacktoHome);
        super.add(jp);
    }

    /**
     * Methode permettant à l'utilisateur de savoir les données
     * elle lui permet de savoir les données qu'il avait mis lors de la creation du rappel
     * @param r permet la recuperation de ces données
     * @return initialises les champs de texte crées plus haut
    */

    public void afficherRappelModif(ModelRappel r){
        modifierTitle.setText("Titre : "+ r.getTitre());
        modifierContent.setText("Contenu : "+ r.getContenu());
        modifierRank.setText("Rang : "+String.valueOf(r.getRang()));
    }

    public JCheckBox getT1(){
        return this.one_color;
    }

    public JCheckBox getT2(){
        return this.two_color;
    }
    public JCheckBox getT3(){
        return this.three_color;
    }
    public JCheckBox getT4(){
        return this.four_color;
    }
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
     * Permet de recuperer ce que l'utilisateur écrit : le titre
     * @return String retourne ce qu'il écrit sous forme de chaine de caractères
    */
    
    public String getnewTitle(){
        return this.modifierTitle.getText();

    }

    /**
     * permet de recupérer ce que l'utilisateur écrit : le contenu
     * @return String retourne ce qu'il écrit sous forme de de chaine de caracteres
    */

    public String getnewContent(){
        return this.modifierContent.getText();
    }
    /**
     * permet de recupérer ce que l'utilisateur écrit : le rang
     * @return String retourne ce qu'il écrit sous forme de caracteres
    */

    public String getnewRank(){
        return this.modifierRank.getText();
    }
    


    
}
