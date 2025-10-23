package fr.iutfbleau.example;

/**
 * Représente un rappel avec ses informations principales. 
 * Un rappel contient un identifiant, un titre, un contenu (facultatif),
 * un thème, un rang et une date de création.
 * @author Algassimou Pellel Diallo, Anhdire Ayoub , Youness BOULALAM
 * @version 1.1
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
     * @param id identifiant du rappel(unique)
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

    /**
     * Méthode permettant de recupérer l'ID d'un Rappel
     * @return int l’identifiant du rappel 
     */
    public int getId() { 
        return id; 
    }

    /** 
     * Methode permettant de recupérer le titre d'un Rappel
     * @return String le titre du rappel 
    */
    
    public String getTitre() { 
        return titre; 
    }

    /**
     * Methode permettant de recupérer le contenu d'un Rappel
     * @return String le contenu du rappel, ou "Pas de contenu." si le champ est vide
     */
    public String getContenu() {
        if (contenu == null) {
            return "Pas de contenu.";
        }
        return contenu;
    }

    /**
     * Methode permettant de recuper le thème d'un Rappel
     * @return int le numéro du thème du rappel(entre 1 et 5) 
    */
    public int getTheme() { 
        return theme; 
    }

    /**
     * Methode permettant de récupérer le rang d'un Rappel
     * @return int le rang du rappel 
    */
    public int getRang() { 
        return rang; 
    }

    /** 
     * Methode permettant de recuperer la date de la création du Rappel
     * @return String La date de création du rappel 
    */
    public String getDate() { 
        return date; 
    }

    /**
    * Change le rang du rappel 
    * @param r le nouveau rang du rappel
    */
    public void setRang(int rang){
        this.rang = rang;
    }

    /**
     * Retourne une représentation textuelle du rappel. 
     * @return String une chaîne contenant toutes les informations du rappel
     */
    @Override
    public String toString() { 
        return "Rappel{id=" + id + ", titre='" + titre + "', contenu='" + contenu 
            + "', theme=" + theme + ", rang=" + rang + ", date='" + date + "'}"; 
    }
}
