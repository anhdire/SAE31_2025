package fr.iutfbleau.example;

import javax.swing.JOptionPane;

/**
 * Classe utilitaire pour gérer l'affichage des messages d'erreur,
 * d'information et de confirmation dans l'interface graphique.
 * 
 * @author Algassimou Pellel Diallo
 */
public class ErrorManager {

    /**
     * Affiche une boîte de dialogue d'erreur avec un message donné.
     *
     * @param message le texte du message d'erreur à afficher
     */
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Affiche une boîte de dialogue d'information avec un message donné.
     *
     * @param message le texte du message d'information à afficher
     */
    public static void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Affiche une boîte de dialogue de confirmation avec un message donné.
     *
     * @param message le texte de la question à poser à l'utilisateur
     * @return true si l'utilisateur clique sur "Oui", false sinon
     */
    public static boolean confirm(String message) {
        return JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION; //
    }
}
