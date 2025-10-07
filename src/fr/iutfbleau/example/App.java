package fr.iutfbleau.example;

public class App {
    public static void main(String[] args) {
        DBManager db = new DBManager();
        ModelRappelDataBase rdb = new ModelRappelDataBase(db.getConnection());
        VueMainFrame vue = new VueMainFrame();
        ControlRappel controller = new ControlRappel(rdb, vue);
        vue.setVisible(true);
    }
}
