package fr.iutfbleau.example;
import java.awt.*;
import javax.swing.*;

public class VueRappelAddPanel extends JPanel {
    private JLabel etiquette_add;
    private JLabel etiquette_add_title;
    private JLabel etiquette_add_content;
    private JLabel etiquette_add_rank;
    private JTextField titre_add;
    private JTextArea contenu_add;
    private JLabel etiquette_theme;
    private JCheckBox theme_used_1; 
    private JCheckBox theme_used_2; 
    private JCheckBox theme_used_3; 
    private JCheckBox theme_used_4;
    private JCheckBox theme_used_5;
    private ButtonGroup bg;
    private JTextField rang;
    private JButton bouton_add;
    private JButton bouton_retour;
    private GridLayout gestionnaire_mise_page;

    public VueRappelAddPanel() {
        super();
        Font f = new Font("SansSerif",Font.BOLD,22); 
        this.gestionnaire_mise_page = new GridLayout(10,1,0,2);
        super.setLayout(gestionnaire_mise_page);
        this.etiquette_add = new JLabel("                      Ajouter un rappel");
        etiquette_add.setForeground(Color.RED);
        etiquette_add.setFont(f);
        this.etiquette_add_title = new JLabel("Nom : ");
        this.titre_add = new JTextField(10);
        this.etiquette_add_content = new JLabel("Contenu :");
        this.contenu_add = new JTextArea(50,50); 
        contenu_add.setLineWrap(true); 
        JScrollPane jsp = new JScrollPane(contenu_add);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.etiquette_theme = new JLabel("Theme : ");
        JPanel jp = new JPanel(new GridLayout(1,5,3,0));
        this.theme_used_1 = new JCheckBox("Rouge");
        this.theme_used_1.setActionCommand("1");
        this.theme_used_2 = new JCheckBox("Jaune");
        this.theme_used_2.setActionCommand("2");
        this.theme_used_3 = new JCheckBox("Vert");
        this.theme_used_3.setActionCommand("3");
        this.theme_used_4 = new JCheckBox("Bleu");
        this.theme_used_4.setActionCommand("4");
        this.theme_used_5 = new JCheckBox("Cyan");
        this.theme_used_5.setActionCommand("5");
        this.bg = new ButtonGroup();
        bg.add(this.theme_used_1);
        bg.add(this.theme_used_2);
        bg.add(this.theme_used_3);
        bg.add(this.theme_used_4);
        bg.add(this.theme_used_5);
        jp.add(this.theme_used_1);
        jp.add(this.theme_used_2);
        jp.add(this.theme_used_3);
        jp.add(this.theme_used_4);
        jp.add(this.theme_used_5);
        this.etiquette_add_rank = new JLabel("Rang : ");
        this.rang = new JTextField(10);
        JPanel jpp = new JPanel();
        GridLayout gl = new GridLayout(1,2,5,0);
        jp.setLayout(gl);
        this.bouton_add = new JButton("Ajouter ce rappel");
        bouton_add.setBackground(new Color(94,105,242));
        this.bouton_retour = new JButton("Revenir en arrière");
        jpp.add(bouton_add);
        jpp.add(bouton_retour);
        super.add(etiquette_add);
        super.add(etiquette_add_title);
        super.add(titre_add);
        super.add(etiquette_add_content); //
        super.add(jsp);
        super.add(etiquette_theme);
        super.add(jp);
        super.add(etiquette_add_rank);
        super.add(rang);
        super.add(jpp);
    }

    public ModelRappel getRappelFromForm() { return null; }
    public void remplirChamps(ModelRappel r) {}
    public void viderChamps() {
        this.titre_add.setText("");
        this.contenu_add.setText("");
        this.rang.setText("");
    }

    public JCheckBox getTheme1(){
        return this.theme_used_1;
    }
    public JCheckBox getTheme2(){
        return this.theme_used_2;
    }

    public JCheckBox getTheme3(){
        return this.theme_used_3;
    }

    public JCheckBox getTheme4(){
        return this.theme_used_4;
    }

    public JCheckBox getTheme5(){
        return this.theme_used_5;
    }

    public JButton getButton(){
        return this.bouton_add;
    }

    public JButton getButtonBack(){
        return this.bouton_retour;
    }

    public String getLabel(){
        return titre_add.getText();
    }
	
    public String getContenu(){
	   return contenu_add.getText();

    } 
    
    public String getRank(){
        return rang.getText();
    }

    public ButtonGroup getGroupeButton(){
        return this.bg;
    }

}



