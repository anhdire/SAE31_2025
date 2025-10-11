package fr.iutfbleau.example;

import java.util.Comparator;

public class ComparateurRang implements Comparator<ModelRappel> {
    @Override
    public int compare(ModelRappel r1, ModelRappel r2) {
        return Integer.compare(r1.getRang(), r2.getRang());
    }
}
