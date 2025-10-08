package fr.iutfbleau.example;

public class ModelRappel {
    private int id;
    private String titre;
    private String contenu;
    private int theme;
    private int rang;

    public ModelRappel(String t, String c, int th, int r) {}

    public String getTitre() { return titre; }
    public String getContenu() { return contenu; }
    public int getTheme() { return theme; }
    public int getRang() { return rang; }
    public String toString() { return titre; }
}
