package fr.iutfbleau.example;
import java.awt.*;
import javax.swing.*;

/**
 * Fenêtre principale de l'application "Papillon".
 *
 * Utilise un CardLayout pour afficher alternativement la liste des rappels,
 * le formulaire d'ajout/modification et la vue de détail.
 *
 * @author DIALLO Algassimou Pellel, ANHDIRE Ayoub, BOULALAM Younes
 *
 */
public class VueMainFrame extends JFrame {

    /**
     * Panel affichant la liste des rappels.
     */
    private VueListePanel listePanel;

    /**
     * Panel contenant le formulaire d'ajout/modification d'un rappel.
     */
    private VueRappelAddPanel formAjoutPanel;

    /**
     * Panel contenant le formulaire de modification d'un rappel.
     */
    private VueRappelModifPanel formModifPanel;

    /**
     * Panel affichant les détails d'un rappel sélectionné.
     */
    private VueDetailPanel detailPanel;

    /**
     * Layout de type "cartes" pour basculer entre les vues.
     */
    private CardLayout cardLayout;

    /**
     * Conteneur principal qui héberge les cartes.
     */
    private JPanel container;


    public static final int WIDTH = 410;
    public static final int HEIGHT = 400;


    /**
     * Construit la fenêtre principale et initialise les composants graphiques.
     * La fenêtre est non redimensionnable, toujours au premier plan et configure
     * la fermeture sur EXIT_ON_CLOSE.
     */
    public VueMainFrame() {
        super("Papillon");
        super.setSize(WIDTH, HEIGHT);
        super.setLocation(0,0);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation des panels
        this.formAjoutPanel = new VueRappelAddPanel();
        this.formModifPanel = new VueRappelModifPanel();
        this.listePanel = new VueListePanel();
        this.detailPanel = new VueDetailPanel();

        // Configuration du CardLayout
        // Le CardLayout affiche une seule carte à la fois.
        this.cardLayout = new CardLayout();
        this.container = new JPanel(cardLayout);

        // Ajout des panels au container avec des identifiants
        container.add(listePanel, "Liste");
        container.add(formAjoutPanel, "FormAjout");
        container.add(detailPanel, "Detail");

        this.add(container);
    }

    /**
     * Affiche la carte identifiée par name et met à jour le titre de la fenêtre.
     *
     * @param name identifiant de la carte ("Liste", "Form" ou "Detail")
     */
    public void showPanel(String name) {
        cardLayout.show(container, name);
        if (name.equals("Liste")) {
            this.setTitle("Liste des rappels");
        } else if (name.equals("Form")) {
            this.setTitle("Ajouter/Modifier un rappel");
        } else if (name.equals("Detail")) {
            this.setTitle("Détails du rappel");
        }
    }

    /**
     * Retourne le panel de détail.
     *
     * @return instance de VueDetailPanel
     */
    public VueDetailPanel getDetailPanel() {
        return detailPanel;
    }

    /**
     * Retourne le panel de liste.
     *
     * @return instance de VueListePanel
     */
    public VueListePanel getListePanel() {
        return listePanel;
    }

    /**
     * Retourne le panel de formulaire d'ajout/modification.
     *
     * @return instance de VueRappelAddPanel
     */
    public VueRappelAddPanel getFormAjoutPanel() {
        return formAjoutPanel;
    }

    /**
     * Retourne le panel de formulaire de modification.
     *
     * @return instance de VueRappelModifPanel
     */
    public VueRappelModifPanel getFormModifPanel() {
        return formModifPanel;
    }

    /**
     * Retourne le CardLayout utilisé pour la fenêtre.
     *
     * @return CardLayout principal
     */
    public CardLayout getCartes() {
        return this.cardLayout;
    }

    /**
     * Retourne le conteneur principal qui contient les cartes.
     *
     * @return JPanel conteneur
     */
    public JPanel getPanel() {

        return this.container;
    }
}
