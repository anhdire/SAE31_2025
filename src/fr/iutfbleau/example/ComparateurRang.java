package fr.iutfbleau.example;

import java.util.Comparator;

/**
 * Comparateur de rappels basé sur le champ {@code rang}.
 * 
 * Permet de trier une liste de {@link ModelRappel} par ordre croissant de rang.
 * @author Algassimou Pellel Diallo
 * @version 1.0
 */
public class ComparateurRang implements Comparator<ModelRappel> {
    // Je compare deux rappels en fonction de leur rang
    @Override
    /**
     * Compare deux rappels en fonction de leur rang.
     * 
     * @param r1 premier rappel à comparer
     * @param r2 second rappel à comparer
     * @return une valeur négative si r1 < r2, zéro s'ils sont égaux, positive sinon
     */
    public int compare(ModelRappel r1, ModelRappel r2) {
        if (r1.getRang() == r2.getRang()) {
            return 0;
        }else if (r1.getRang() < r2.getRang()) {
            return -1;
        } else {
            return 1;
        }
    }
}
