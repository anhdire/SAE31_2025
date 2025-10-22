package fr.iutfbleau.example;

import java.awt.event.ActionListener;
import javax.swing.*;

public class Utils {

    /**
     * Supprime tous les ActionListener attachés à un bouton.
     *
     * @param bouton Le bouton à nettoyer
     */
    public static void resetListeners(JButton bouton) {
        for (ActionListener al : bouton.getActionListeners()) {
            bouton.removeActionListener(al);
        }
    }
}

