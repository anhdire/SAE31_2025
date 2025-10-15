package fr.iutfbleau.example;

public class ModelRappel {
    private int id;
    private String titre;
    private String contenu;
    private int theme;
    private int rang;
    private String date;

    public ModelRappel(int id, String t, String c, int th, int r, String date) {
        this.id = id;
        this.titre = t;
        this.contenu = c;
        this.theme = th;
        this.rang = r;
        this.date = date;
    }

    public int getId(){
        return id; 
    }
    public String getTitre(){
        return titre;
    }
    public String getContenu() {
        if (contenu == null) {
            return "Pas de contenu.";
        }
        return contenu;
    }
    public int getTheme() { 
        return theme; 
    }
    public int getRang() { 
        return rang; 
    }
    public String getDate() {
        return date;
    }
    @Override
    public String toString() { 
        return "Rappel{id=" + id + ", titre='" + titre + "', contenu='" + contenu + "', theme=" + theme + ", rang=" + rang + ", date='" + date + "'}"; 
    }
}
