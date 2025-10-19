package fr.iutfbleau.example;

import java.awt.Color;
import java.util.List;
import javax.swing.JButton;


public class ControleurRappel {
    private VueMainFrame vue;
    private ModelRappelDAO dao;
    private boolean listeInitialisee = false;


    public ControleurRappel(ModelRappelDAO d, VueMainFrame vue) {
        this.dao = d;
        this.vue = vue;

        // Ajout des ecouteurs pour les boutons
        this.vue.getListePanel().getButtonAdd().addActionListener(new ListenerBtn(this));
        this.vue.getFormAjoutPanel().getButtonBack().addActionListener(new ListenerBtn(this));
        this.vue.getFormAjoutPanel().getButton().addActionListener(new ListenerAjoutBD(this, vue));
      


        // afficher la liste des rappels au demarrage.
        this.initialiserListe();
        this.afficherListe();


        // Ajout des ecouteurs pour les boutons de changement de theme
        this.vue.getFormAjoutPanel().getTheme1().addActionListener(new ListenerTheme(this));
        this.vue.getFormAjoutPanel().getTheme2().addActionListener(new ListenerTheme(this));
        this.vue.getFormAjoutPanel().getTheme3().addActionListener(new ListenerTheme(this));
        this.vue.getFormAjoutPanel().getTheme4().addActionListener(new ListenerTheme(this));
        this.vue.getFormAjoutPanel().getTheme5().addActionListener(new ListenerTheme(this));    
    }

    public void initialiserListe() {
        if (listeInitialisee) return;
        try {
            List<ModelRappel> rappels = dao.getAllRappels();
            vue.getListePanel().rafraichirListe(rappels);

            // Attacher les listeners une seule fois au btn ...
            for (JButton btn : vue.getListePanel().getButtonsRappels()) {
                btn.addActionListener(new ListenerBtn(this));
            }

            listeInitialisee = true;

        } catch (Exception e) {
            String message = """
                Impossible de charger les rappels :
                    \t- Vérifiez que votre connexion internet fonctionne.
                    \t- Vérifiez que le service de rappels est disponible.
                    \t- Réessayez dans quelques instants.
                    """;
            ErrorManager.showError(message);
            System.exit(1);
        }
}



    public  void afficherListe() {

        // ce code est a suprimer mais je fais les teste dabord 
        // Gestion de erreur et communication graphique
        // try {
        //     List<ModelRappel> rappels = dao.getAllRappels();
        //     vue.getListePanel().rafraichirListe(rappels);
        //     // Ecouteur pour les boutons de la liste des rappels
        //     for (JButton btn : this.vue.getListePanel().getButtonsRappels()) {
        //     btn.addActionListener(new ListenerBtn(this));
        // }
        // } catch (Exception e) {
        //     String message = """
        //            Impossible de charger les rappels :
        //             \t- Vérifiez que votre connexion internet fonctionne.
        //             \t- Vérifiez que le service de rappels est disponible.
        //             \t- Réessayez dans quelques instants.
        //             """;
        //     ErrorManager.showError(message);
        //     // Fin du programme
        //     System.exit(1);
        //     return;
        // }
        vue.showPanel("Liste");
    }

    public void afficherFormModification(ModelRappel r) {
        System.out.println(r.getDate());
        vue.getFormModifPanel().afficherRappelModif(r); //
        vue.showPanel("FormModif");
    }

    public void afficherFormAjout() {
        vue.showPanel("FormAjout");
    }

    public void afficherDetail(ModelRappel r) {
        vue.getDetailPanel().afficherRappel(r);
        vue.showPanel("Detail");

        this.vue.getDetailPanel().getBtnRetour().addActionListener(new ListenerBtn(this));
        this.vue.getDetailPanel().getBtnModifier().addActionListener(new ListenerBtn(this));
        this.vue.getDetailPanel().getBtnSupprimer().addActionListener(new ListenerBtn(this));

        // V1
        // this.vue.getDetailPanel().getBtnRetour().addActionListener(new ListenerRetourListe(this));
        // this.vue.getDetailPanel().getBtnModifier().addActionListener(new ListenerModifierRappel(this));
        // this.vue.getDetailPanel().getBtnSupprimer().addActionListener(new ListenerSupprimerRappel(this));
    }

    public void ajouterRappel(ModelRappel r) {
        this.dao.ajouterRappel(r);

        this.listeInitialisee = false;
        this.initialiserListe();
        this.afficherListe();        
    }

    public void modifierRappel(ModelRappel r) {
        this.dao.modifierRappel(r);
    }
   
    public void supprimerRappel(int id) {
    }

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
