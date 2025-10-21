package fr.iutfbleau.example;

import java.awt.Color;
import java.awt.event.*;
import java.util.List;
import  javax.swing.JButton;

public class ControleurRappel {
    private VueMainFrame vue;
    private ModelRappelDAO dao;
    private boolean listeInitialisee = false;


    public ControleurRappel(ModelRappelDAO d, VueMainFrame vue) {
        this.dao = d;
        this.vue = vue;

   


        // Ajout des ecouteurs pour les boutons
        this.vue.getFormModifPanel().getButtonRetour().addActionListener(new ListenerBtn(this));
        this.vue.getListePanel().getButtonAdd().addActionListener(new ListenerBtn(this));
        this.vue.getFormAjoutPanel().getButtonBack().addActionListener(new ListenerBtn(this));
        this.vue.getFormAjoutPanel().getButton().addActionListener(new ListenerAjoutBD(this, vue));
        this.vue.getFormModifPanel().getButtonModification().addActionListener(new ListenerModifieBD(this,vue));


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
        vue.showPanel("Liste");
    }

    public void afficherFormModification(ModelRappel r) {
        vue.getFormModifPanel().afficherRappelModif(r);
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

        System.out.println("AJOUT DU PREMIER LISTNER");
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
        // Avoir plusieur action listner sur btnsuprimer cause une redondance sur le Jdialog de confirmation 
        JButton btn = this.vue.getDetailPanel().getBtnSupprimer();
        for (ActionListener al : btn.getActionListeners()) {
            btn.removeActionListener(al);
            System.out.println("SUPPRESSION");
        }
        this.vue.getDetailPanel().getBtnSupprimer().addActionListener(new ListenerBtn(this));
        System.out.println("AJOUT DU DANS LA fonction supprimer juste apres la boucle de supression ");

        if (ErrorManager.confirm("Voulez-vous vraiment supprimer ce rappel ?")) {
            try {
                dao.supprimerRappel(id);
                this.listeInitialisee = false;
                this.initialiserListe();
                this.afficherListe();
            } catch (Exception e) {
                ErrorManager.showError("Erreur lors de la suppression du rappel.");
            }
        }        
    }

    public void changerTheme(int i) {
        if(i == 1){
            this.vue.getFormAjoutPanel().setBackground(new Color(255, 236, 236));  // Rouge
        }
        if(i == 2){
			this.vue.getFormAjoutPanel().setBackground(new Color(255, 249, 230));  // Jaune
        }
        if(i == 3){
            this.vue.getFormAjoutPanel().setBackground(new Color(233, 255, 233));  // Vert
        }
        if(i == 4){
            this.vue.getFormAjoutPanel().setBackground(new Color(230, 240, 255));  // Bleu
        }
        if(i == 5){
            this.vue.getFormAjoutPanel().setBackground(new Color(240, 240, 240)); // Gris
        }
    }
}
