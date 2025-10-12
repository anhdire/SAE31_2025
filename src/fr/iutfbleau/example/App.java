package fr.iutfbleau.example;
public class App {
    public static void main(String[] args) {
        DBManager db = new DBManager();
        ModelRappelDAO modelRappelDAO = new ModelRappelDAO(db.getConnection());
        VueMainFrame vue = new VueMainFrame();
        ThemeListener th = new ThemeListener(vue.getFormPanel());
        ControleurRappel controller = new ControleurRappel(modelRappelDAO, vue);
        vue.setVisible(true);
    }
}
