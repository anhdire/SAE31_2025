package fr.iutfbleau.example;

import java.sql.*;
import java.util.*;

/**
 * Classe permettant d'interagir avec la base de données pour gérer les rappels.
 */
public class ModelRappelDAO {

    /** Connexion à la base de données */
    private Connection connection;

    /**
     * Constructeur qui reçoit une connexion active.
     * @param c la connexion à utiliser
     */
    public ModelRappelDAO(Connection c) { 
        this.connection = c; 
    }

    /**
     * Ajoute un rappel dans la base.
     * @param r rappel à ajouter
     */
    public void ajouterRappel(ModelRappel r) {
        String sql = "INSERT INTO " + DBManager.TABLE_NAME + " (Titre,Contenu,Theme,Rang) VALUES (?,?,?,?)";
        PreparedStatement pst = null;

        try {
            pst = this.connection.prepareStatement(sql);
            pst.setString(1, r.getTitre());
            pst.setString(2, r.getContenu());
            pst.setInt(3, r.getTheme());
            pst.setInt(4, r.getRang());
            pst.executeUpdate();
        } catch (SQLException e) {
            ErrorManager.showError("""
                Une erreur est survenue pendant l'ajout du rappel.

                Recommandations :
                \t- Vérifiez votre connexion internet.
                \t- Essayez de relancer l'application si le problème persiste.
            """);
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (SQLException ignored) {}
        }
    }

    /**
     * Supprime un rappel à partir de son identifiant.
     * @param id identifiant du rappel
     */
    public void supprimerRappel(int id) {
        String sql = "DELETE FROM " + DBManager.TABLE_NAME + " WHERE id = ?";
        PreparedStatement pst = null;

        try {
            pst = this.connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            ErrorManager.showError("""
                Impossible de supprimer le rappel.
                Recommandations :
                \t- Fermez puis rouvrez la fiche du rappel et réessayez.
                \t- Si le problème persiste, redémarrez l'application.
            """);
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (SQLException ignored) {}
        }
    }

    /**
     * Récupère tous les rappels de la base.
     * @return liste de rappels
     * @throws SQLException si la requête échoue
     */
    public List<ModelRappel> getAllRappels() throws SQLException {
        List<ModelRappel> rappels = new ArrayList<>();
        String sql = "SELECT * FROM " + DBManager.TABLE_NAME;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = this.connection.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                rappels.add(new ModelRappel(
                    rs.getInt("id"),
                    rs.getString("Titre"),
                    rs.getString("Contenu"),
                    rs.getInt("Theme"),
                    rs.getInt("Rang"),
                    rs.getString("DateCreation")
                ));
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException ignored) {}
        }

        return rappels;
    }

    /**
     * Récupère un rappel spécifique à partir de son identifiant.
     * @param id identifiant du rappel
     * @return le rappel correspondant
     */
    public ModelRappel getOneRappel(int id) {
        String sql = "SELECT Titre, Contenu, Theme, Rang, DateCreation FROM " + DBManager.TABLE_NAME + " WHERE Id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModelRappel rappel = null;

        try {
            pst = this.connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                rappel = new ModelRappel(
                    id,
                    rs.getString("Titre"),
                    rs.getString("Contenu"),
                    rs.getInt("Theme"),
                    rs.getInt("Rang"),
                    rs.getString("DateCreation")
                );
            }

        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de la lecture du rappel.\nVeuillez vérifier votre connexion.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException ignored) {}
        }

        return rappel;
    }

    /**
     * Modifie un rappel existant dans la base de données.
     * @param r le rappel à modifier avec ses nouvelles valeurs
     */
    public void modifierRappel(ModelRappel r) {
        String sql = "UPDATE " + DBManager.TABLE_NAME + " SET Titre = ?, Contenu = ?, Theme = ?, Rang = ? WHERE ID = ?";
        PreparedStatement pst = null;

        try {
            pst = this.connection.prepareStatement(sql);
            pst.setString(1, r.getTitre());
            pst.setString(2, r.getContenu());
            pst.setInt(3, r.getTheme());
            pst.setInt(4, r.getRang());
            pst.setInt(5, r.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            ErrorManager.showError("""
                Impossible de mettre à jour le rappel.
                Recommandations :
                \t- Vérifiez votre connexion internet.
                \t- Réessayez après quelques instants.
                \t- Si le problème persiste, redémarrez l'application.
            """);
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (SQLException ignored) {}
        }
    }
}
