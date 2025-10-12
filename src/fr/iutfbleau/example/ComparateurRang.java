package fr.iutfbleau.example;

import java.util.Comparator;

public class ComparateurRang implements Comparator<ModelRappel> {
    // Je compare deux rappels en fonction de leur rang
    @Override
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
