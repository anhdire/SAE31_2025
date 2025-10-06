import java.awt.event.*;
import java.util.*;

public class ControlRappel implements ActionListener {
    private VueMainFrame vue;
    private ModelRappelDataBase db;

    public ControlRappel(ModelRappelDataBase dao, VueMainFrame vue) {
        this.db = dao;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {}

    public void afficherListe() {}
    public void afficherForm(ModelRappel r) {}
    public void afficherDetail(ModelRappel r) {}
    public void ajouterRappel(ModelRappel r) {}
    public void modifierRappel(ModelRappel r) {}
    public void supprimerRappel(int id) {}
    public void chargerTousLesRappels() {}
}
