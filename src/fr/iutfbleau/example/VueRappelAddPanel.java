package fr.iutfbleau.example;
import java.awt.*;
import javax.swing.*;

public class VueRappelAddPanel extends JPanel {
    private JLabel etiquette_add;
    private JTextField titre_add;
    private JTextArea contenu_add;
    private JLabel etiquette_theme;
    private JCheckBox theme_used_1; // l'utilisateur chosit son theme sous forme de choix avec des boutons radio
    private JCheckBox theme_used_2; // l'utilisateur chosit son theme sous forme de choix avec des boutons radio
    private JCheckBox theme_used_3; // l'utilisateur chosit son theme sous forme de choix avec des boutons radio
    private JTextField rang;
    private JButton bouton_add;
    private GridLayout gestionnaire_mise_page;

    public VueRappelAddPanel() {
        super();
        Font f = new Font("SansSerif",Font.BOLD,22); // police pour un meilleur visuel
        this.gestionnaire_mise_page = new GridLayout(7,1,0,5); // gestionnaire de mise en page avec un espace entre les composants
        super.setLayout(gestionnaire_mise_page);
        this.etiquette_add = new JLabel("                           Ajouter un rappel"); // rappeller à l'utilisateur qu'il va ajouter un rappel
        etiquette_add.setForeground(Color.RED); // le mettre en rouge pour plus d'evidence
        etiquette_add.setFont(f);
        this.titre_add = new JTextField("Nom : ",10); // un champ de texte pour le nom du rappel
        this.contenu_add = new JTextArea("Contenu : ",50,50); // une zone de texte pour le contenu du rappel
        contenu_add.setLineWrap(true); // permet de changer de ligne quand l'utilisateur entre trop de texte
        JScrollPane jsp = new JScrollPane(contenu_add);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);// afficher une barre de navigation si ca depasse la zone de texte
        this.etiquette_theme = new JLabel("Theme : ");
        JPanel jp = new JPanel(new GridLayout(1,3,5,0));
        this.theme_used_1 = new JCheckBox("1");
        this.theme_used_2 = new JCheckBox("2");
        this.theme_used_3 = new JCheckBox("3");
        ButtonGroup bg = new ButtonGroup();
        bg.add(this.theme_used_1);
        bg.add(this.theme_used_2);
        bg.add(this.theme_used_3);
        jp.add(this.theme_used_1);
        jp.add(this.theme_used_2);
        jp.add(this.theme_used_3);
        this.rang = new JTextField("Rang : ");
        this.bouton_add = new JButton("Ajouter ce rappel");
        bouton_add.setBackground(new Color(94,105,242));
        super.add(etiquette_add);
        super.add(titre_add);
        super.add(jsp);
        super.add(etiquette_theme);
        super.add(jp);
        super.add(rang);
        super.add(bouton_add);
    }

    public ModelRappel getRappelFromForm() { return null; }
    public void remplirChamps(ModelRappel r) {}
    public void viderChamps() {}
}
