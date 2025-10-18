package fr.iutfbleau.example;
import java.awt.*;
import javax.swing.*;

public class VueRappelAddPanel extends JPanel {
    private JLabel etiquette_add;
    private JTextField titre_add;
    private JTextArea contenu_add;
    private JLabel etiquette_theme;
    private JCheckBox theme_used_1; 
    private JCheckBox theme_used_2; 
    private JCheckBox theme_used_3; 
    private JCheckBox theme_used_4;
    private JCheckBox theme_used_5;
    private JTextField rang;
    private JButton bouton_add;
    private JButton bouton_retour;
    private GridLayout gestionnaire_mise_page;

    public VueRappelAddPanel() {
        super();
        Font f = new Font("SansSerif",Font.BOLD,22); 
        this.gestionnaire_mise_page = new GridLayout(7,1,0,5);
        super.setLayout(gestionnaire_mise_page);
        this.etiquette_add = new JLabel("                     Ajouter un rappel");
        etiquette_add.setForeground(Color.RED);
        etiquette_add.setFont(f);
        this.titre_add = new JTextField("Nom : ",10);
        this.contenu_add = new JTextArea("Contenu : ",50,50); 
        contenu_add.setLineWrap(true); 
        JScrollPane jsp = new JScrollPane(contenu_add);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.etiquette_theme = new JLabel("Theme : ");
        JPanel jp = new JPanel(new GridLayout(1,5,3,0));
        this.theme_used_1 = new JCheckBox("1(Rouge)");
        this.theme_used_2 = new JCheckBox("2(Jaune)");
        this.theme_used_3 = new JCheckBox("3(Vert)");
        this.theme_used_4 = new JCheckBox("4(Bleu)");
        this.theme_used_5 = new JCheckBox("5(Cyan)");
        ButtonGroup bg = new ButtonGroup();
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
        this.rang = new JTextField("Rang : ");
        JPanel jpp = new JPanel();
        GridLayout gl = new GridLayout(1,2,5,0);
        jp.setLayout(gl);
        this.bouton_add = new JButton("Ajouter ce rappel");
        bouton_add.setBackground(new Color(94,105,242));
        this.bouton_retour = new JButton("Retour");
        bouton_retour.setActionCommand("retour"); // ne pas changer  svp
        jpp.add(bouton_add);
        jpp.add(bouton_retour);
        super.add(etiquette_add);
        super.add(titre_add);
        super.add(jsp);
        super.add(etiquette_theme);
        super.add(jp);
        super.add(rang);
        super.add(jpp);
    }

    public ModelRappel getRappelFromForm() { return null; }
    public void remplirChamps(ModelRappel r) {}
    public void viderChamps() {}

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
}






