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
    private Color couleur;
    private JLabel modifierRappel; 
    private JTextField modifierTitle;
    private JTextArea modifierContent;
    private JTextField modifierRank;
    private JCheckBox one_color;
    private JCheckBox two_color;
    private JCheckBox three_color;
    private JCheckBox four_color;
    private JCheckBox five_color;
    private JButton confirmModification;
    private JButton getBacktoHome;

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
        bg.add(one_color);
        this.two_color = new JCheckBox("Jaune");
        bg.add(two_color);
        this.three_color = new JCheckBox("Vert");
        bg.add(three_color);
        this.four_color = new JCheckBox("Bleu");
        bg.add(four_color);
        this.five_color = new JCheckBox("Gris");
        bg.add(five_color);
        panel.add(one_color);panel.add(two_color);panel.add(three_color);panel.add(four_color);panel.add(five_color);
        super.add(panel);
        GridLayout gr = new GridLayout(1,2,5,5);
        JPanel jp = new JPanel();
        jp.setLayout(gr);
        this.confirmModification = new JButton("Confirmer les modification");
        confirmModification.setFont(new Font("Merriweather",Font.PLAIN,14));
        confirmModification.setBackground(new Color(39,245,173));
        this.getBacktoHome = new JButton("Revenir à l'accueil");
        getBacktoHome.setFont(new Font("Open Sans",Font.PLAIN,14));
        getBacktoHome.setBackground(new Color(237,69,90));
        jp.add(confirmModification);
        jp.add(getBacktoHome);
        super.add(jp);
    }


    public void afficherRappelModif(ModelRappel r){
        modifierTitle.setText(r.getTitre());
        modifierContent.setText(r.getContenu());
        modifierRank.setText(String.valueOf(r.getRang()));
    }
    
}
