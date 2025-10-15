package fr.iutfbleau.example;

import javax.swing.JOptionPane;

public class ErrorManager {

    public static void showError(String message) {
        
        JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String message) {
        return JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION;
    }
}
