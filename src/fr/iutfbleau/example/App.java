package fr.iutfbleau.example;

public class App {
    public static void main(String[] args) {
<<<<<<< HEAD
        //DBManager db = new DBManager();
        //ModelRappelDataBase rdb = new ModelRappelDataBase(db.getConnection());
        VueMainFrame vue = new VueMainFrame();
        //ControleurRappel controller = new ControleurRappel(rdb, vue);
=======
        DBManager db = new DBManager();
        ModelRappelDAO modelRappelDAO = new ModelRappelDAO(db.getConnection());
        VueMainFrame vue = new VueMainFrame();
        ControleurRappel controller = new ControleurRappel(modelRappelDAO, vue);
>>>>>>> feature/US6
        vue.setVisible(true);
    }
}
