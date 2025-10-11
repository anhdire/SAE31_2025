package fr.iutfbleau.example;

public class App {
    public static void main(String[] args) {
        //DBManager db = new DBManager();
        //ModelRappelDataBase rdb = new ModelRappelDataBase(db.getConnection());
        VueMainFrame vue = new VueMainFrame();
        //ControleurRappel controller = new ControleurRappel(rdb, vue);
        vue.setVisible(true);
    }
}
