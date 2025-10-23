package fr.iutfbleau.example;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;

/**
 * Contrôleur de l'application de gestion des rappels.
 */
public class ControleurRappel {
    private VueMainFrame vue;
    private ModelRappelDAO dao;
    private boolean listeInitialisee = false;


    /**
     * Constructeur du contrôleur.
     * @param d le DAO pour accéder à la base de données
     * @param vue la vue principale de l'application
     * @author Algassimou Pellel Diallo
     * @version 1.0
     */
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

    /**
     * Initialise la liste des rappels depuis la base de données.
     * Permet aussi d'optimiser le chargement des rappels, 
     * En evitant de charger la liste des rappels a chaque fois.
     */
    public void initialiserListe() {
        if (listeInitialisee) return;
        try {
            List<ModelRappel> rappels = dao.getAllRappels();
            vue.getListePanel().rafraichirListe(rappels);

            // Ajout des ecouteurs pour les boutons de la liste des rappels (optimisation)
            for (JButton btn : vue.getListePanel().getButtonsRappels()) {
                btn.addActionListener(new ListenerBtn(this));
            }

            listeInitialisee = true;

        } catch (SQLException e) {
            String message = 
            "Impossible de charger les rappels :"+
            "\t- Vérifiez que votre connexion internet fonctionne, et réessayez dans quelques instants.\n"+
            "L'application Va se fermer";
            ErrorManager.showError(message);
            System.exit(1);
        }
    }

    /**
     * Affiche le panel de la liste des rappels.
     */
    public  void afficherListe() {
        vue.showPanel("Liste");
    }

    /**
     * Affiche le formulaire de modification d'un rappel.
     * @param r le rappel à modifier
     */
    public void afficherFormModification(ModelRappel r) {
        
        vue.getFormModifPanel().afficherRappelModif(r);
        vue.showPanel("FormModif");
    }

    /**
     * Affiche le formulaire d'ajout d'un nouveau rappel.
     */
    public void afficherFormAjout() {
        vue.showPanel("FormAjout");
    }

    /**
     * Affiche les détails d'un rappel.
     * @param r le rappel à afficher
     */
    public void afficherDetail(ModelRappel r) {
        vue.getDetailPanel().afficherRappel(r);
        vue.showPanel("Detail");

        // Evite redondance sur le Jdialog de confirmation et permet aussi de suprimer la redondance des listeners
        this.resetListeners(this.vue.getDetailPanel().getBtnSupprimer());
        this.resetListeners(this.vue.getDetailPanel().getBtnRetour());
        this.resetListeners(this.vue.getDetailPanel().getBtnModifier());

        // Rajout de un seul listner
        this.vue.getDetailPanel().getBtnRetour().addActionListener(new ListenerBtn(this));
        this.vue.getDetailPanel().getBtnModifier().addActionListener(new ListenerBtn(this));
        this.vue.getDetailPanel().getBtnSupprimer().addActionListener(new ListenerBtn(this));
    }

    /**
     * Ajoute un nouveau rappel et rafraîchit la liste.
     * @param r le rappel à ajouter
     */
    public void ajouterRappel(ModelRappel r) {
        // lola
        int maxrang = dao.getMaxRang();
        maxrang++;
        r.setRang(maxrang);

        this.dao.ajouterRappel(r);

        this.listeInitialisee = false;
        this.initialiserListe();
        this.afficherListe();
        ErrorManager.showInfo("Le rappel a été ajouté avec succès !");        
    }
   

    /**
     * Modifie un rappel existant et rafraîchit la liste.
     * @param r le rappel à modifier
    */
    public void modifierRappel(ModelRappel r) {
        this.dao.modifierRappel(r);
        this.listeInitialisee = false;
        this.initialiserListe();
        this.afficherListe();
        ErrorManager.showInfo("Le rappel a été modifié avec succès !");  
    }
   
    /**
     * Supprime un rappel après confirmation de l'utilisateur.
     * @param id l'identifiant du rappel à supprimer
     */

    public void supprimerRappel(int id) {
        // Avoir plusieur action listner sur btnsuprimer cause une redondance sur le Jdialog de confirmation 
        this.resetListeners(this.vue.getDetailPanel().getBtnSupprimer());
        this.vue.getDetailPanel().getBtnSupprimer().addActionListener(new ListenerBtn(this));
        
        if (ErrorManager.confirm("Voulez-vous vraiment supprimer ce rappel ?")) {
            dao.supprimerRappel(id);
            dao.reorganiserRangs();
            this.listeInitialisee = false;
            this.initialiserListe();
            this.afficherListe();
            ErrorManager.showInfo("Le rappel a été supprimé avec succès !");
        }
        
    }

    /**
     * Change le thème de couleur du formulaire d'ajout.
     * @param i le numéro du thème (1 à 5)
     */
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


    public void deplacerRappelVersHaut(ModelRappel r) {
        if (r.getRang() <= 0) return; // il est deja en haut
    
        int rangActuel = r.getRang();
        int rangVoisin = rangActuel - 1;
    
        ModelRappel voisin = dao.getRappelParRang(rangVoisin);
        if (voisin != null) {
            dao.updateRang(r.getId(), rangVoisin);
            dao.updateRang(voisin.getId(), rangActuel);
            afficherListe();
        }
    }


    /**
     * Déplace un rappel vers le haut ou le bas dans la liste.
     * @param id identifiant du rappel à déplacer
     * @param versLeHaut true pour monter, false pour descendre
     */
    public void deplacerRappel(int id, boolean versLeHaut) {
        ModelRappel courant = dao.getOneRappel(id);

        if (courant == null) {
            ErrorManager.showError("Rappel introuvable.");
            return;
        }

        int rangActuel = courant.getRang();
        int rangVoisin = versLeHaut ? rangActuel - 1 : rangActuel + 1;

        ModelRappel voisin = dao.getRappelParRang(rangVoisin);

        if (voisin == null) {
            ErrorManager.showInfo("Déplacement impossible.");
            return;
        }

        dao.echangerRangs(courant.getId(), rangActuel, voisin.getId(), rangVoisin);
        this.listeInitialisee = false;
        this.initialiserListe();
        this.afficherListe();
    }


    /**
     * Supprime tous les ActionListener attachés à un bouton.
     *
     * @param bouton Le bouton à nettoyer
     */
    public void resetListeners(JButton bouton) {
        for (ActionListener al : bouton.getActionListeners()) {
            bouton.removeActionListener(al);
        }
    }

}
