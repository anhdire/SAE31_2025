package fr.iutfbleau.example;

import java.awt.Color;
import java.util.List;
import javax.swing.JButton;


public class ControleurRappel {
    private VueMainFrame vue;
    private ModelRappelDAO dao;

    public ControleurRappel(ModelRappelDAO d, VueMainFrame vue) {
        this.dao = d;
        this.vue = vue;


        // Ajout des ecouteurs pour les boutons
        this.vue.getListePanel().getButtonAdd().addActionListener(new ListenerAjouterRappel(this));
        this.vue.getFormAjoutPanel().getButtonBack().addActionListener(new ListenerRetourListe(this));


        // Ecouteur pour les boutons de la liste des rappels
        for (JButton btn : this.vue.getListePanel().getButtonsRappels()) {
            btn.addActionListener(new ListenerVoirDetail(this));
        }

        // Ajout des ecouteurs pour les boutons de changement de theme
        this.vue.getFormAjoutPanel().getTheme1().addActionListener(new ListenerTheme(this));
        this.vue.getFormAjoutPanel().getTheme2().addActionListener(new ListenerTheme(this));
        this.vue.getFormAjoutPanel().getTheme3().addActionListener(new ListenerTheme(this));
        this.vue.getFormAjoutPanel().getTheme4().addActionListener(new ListenerTheme(this));
        this.vue.getFormAjoutPanel().getTheme5().addActionListener(new ListenerTheme(this));    

        // afficher la liste des rappels au demarrage
        this.afficherListe();
    }


    public  void afficherListe() {
        // Gestion de erreur et communication graphique
        try {
            List<ModelRappel> rappels = dao.getAllRappels();
            vue.getListePanel().rafraichirListe(rappels);
        } catch (Exception e) {
            String message = """
                    Impossible de charger les rappels : 
                    \t -Verifier la connexion à la base de données.
                    \t -Vérifier que le serveur MySQL est démarré.
                    \t -Vérifier les paramètres de connexion dans ModelRappelDAO.
                    """;
            ErrorManager.showError(message);
            return;
        }
        vue.showPanel("Liste");
    }

    public void afficherFormModification(ModelRappel r) {
        vue.showPanel("FormModif");
    }

    public void afficherFormAjout() {
        vue.showPanel("FormAjout");
    }

    public void afficherDetail(ModelRappel r) {
        vue.getDetailPanel().afficherRappel(r);
        vue.showPanel("Detail");
    }

    public void ajouterRappel(ModelRappel r) {
        this.dao.ajouterRappel(r);
        this.afficherListe();        
    }

    public void modifierRappel(ModelRappel r) {
      
    }
    public void supprimerRappel(int id) {}

    public void changerTheme(int i) {
        //System.out.println("Changement de theme vers le theme " + i);
        if(i == 1){
            this.vue.getFormAjoutPanel().setBackground(new Color(0xFFD6D6)); // Rouge
        }
        if(i == 2){
			this.vue.getFormAjoutPanel().setBackground(new Color(0xFFF5CC)); // Jaune
        }
        if(i == 3){
            this.vue.getFormAjoutPanel().setBackground(new Color(0xDFFFD6)); // Vert
        }
        if(i == 4){
            this.vue.getFormAjoutPanel().setBackground(new Color(0xD6E9FF)); // Bleu
        }
        if(i == 5){
            this.vue.getFormAjoutPanel().setBackground(new Color(0xD0F0FD)); // Cyan
        }
    }
}
