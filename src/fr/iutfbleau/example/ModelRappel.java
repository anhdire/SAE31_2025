package fr.iutfbleau.example;

/**
 * Représente un rappel avec ses informations principales.
 * 
 * Un rappel contient un identifiant, un titre, un contenu (facultatif),
 * un thème, un rang et une date de création.
 */
public class ModelRappel {

    /** Identifiant unique du rappel. */
    private int id;

    /** Titre du rappel. */
    private String titre;

    /** Contenu ou description du rappel (peut être nul). */
    private String contenu;

    /** Numéro du thème associé au rappel (entre 1 et 5). */
    private int theme;

    /** Rang du rappel (utilisé pour le tri ou l’affichage). */
    private int rang;

    /** Date de création du rappel. */
    private String date;

    /**
     * Crée un nouveau rappel avec les informations données.
     * 
     * @param id identifiant du rappel
     * @param t titre du rappel
     * @param c contenu du rappel (peut être null)
     * @param th thème du rappel
     * @param r rang du rappel
     * @param date date de création du rappel
     */
    public ModelRappel(int id, String t, String c, int th, int r, String date) {
        this.id = id;
        this.titre = t;
        this.contenu = c;
        this.theme = th;
        this.rang = r;
        this.date = date;
    }

    /** @return l’identifiant du rappel */
    public int getId() { 
        return id; 
    }

    /** @return le titre du rappel */
    public String getTitre() { 
        return titre; 
    }

    /**
     * @return le contenu du rappel, ou "Pas de contenu." si le champ est vide
     */
    public String getContenu() {
        if (contenu == null) {
            return "Pas de contenu.";
        }
        return contenu;
    }

    /** @return le numéro du thème du rappel */
    public int getTheme() { 
        return theme; 
    }

    /** @return le rang du rappel */
    public int getRang() { 
        return rang; 
    }

    /** @return la date de création du rappel */
    public String getDate() { 
        return date; 
    }

    /**
     * Retourne une représentation textuelle du rappel.
     * 
     * @return une chaîne contenant toutes les informations du rappel
     */
    @Override
    public String toString() { 
        return "Rappel{id=" + id + ", titre='" + titre + "', contenu='" + contenu 
            + "', theme=" + theme + ", rang=" + rang + ", date='" + date + "'}"; 
    }
}
