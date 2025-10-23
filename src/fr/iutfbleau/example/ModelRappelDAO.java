package fr.iutfbleau.example;

import java.sql.*;
import java.util.*;

/**
 * DAO pour gérer les rappels dans la base de données.
 * @author DIALLO Algassimou Pellel, ANHDIRE Ayoub , BOULALAM Youness
 * @version 1.0
 */
public class ModelRappelDAO {

    private Connection connection;

    public ModelRappelDAO(Connection c) {
        this.connection = c;
    }

    /**
     * Methode permettant d'ajouter un rappel dans la base de données
     * @param r permet de chosir les champs que l'on veut insérer
    */
    public void ajouterRappel(ModelRappel r) {
        String sql = "INSERT INTO " + DBManager.TABLE_NAME + " (Titre, Contenu, Theme, Rang) VALUES (?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = this.connection.prepareStatement(sql);
            pst.setString(1, r.getTitre());
            pst.setString(2, r.getContenu());
            pst.setInt(3, r.getTheme());
            pst.setInt(4, r.getRang());
            pst.executeUpdate();
        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de l'ajout du rappel.");
        } finally {
            try { if (pst != null) pst.close(); } catch (SQLException ignorer) {}
        }
    }
    /**
     * Methode permettant de supprimer un rappel dans la BASE DE DONNEES
     * @param id utilisé dans la clause where pour supprimer la ligne du Rappel
    */

    public void supprimerRappel(int id) {
        String sql = "DELETE FROM " + DBManager.TABLE_NAME + " WHERE id = ?";
        PreparedStatement pst = null;
        try {
            pst = this.connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de la suppression du rappel.");
        } finally {
            try { if (pst != null) pst.close(); } catch (SQLException ignorer) {}
        }
    }

    /**
     * Methode permettant de mettre à jour dans la base de données
     * @param r permet de mettre à jour les nouvelles données dans la BASE DE DONNEES
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
            ErrorManager.showError("Erreur lors de la modification du rappel.");
        } finally {
            try { 
                if(pst != null) {
                    pst.close();
                } 
            }catch (SQLException ignorer) {}
        }
    }

    /**
     * Récupère un rappel à partir de son identifiant.
     * @param id identifiant du rappel
     * @return ModelRappel le rappel correspondant, ou null si introuvable
     */
    public ModelRappel getOneRappel(int id) {
        String sql = "SELECT * FROM " + DBManager.TABLE_NAME + " WHERE id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModelRappel rappel = null;

        try {
            pst = this.connection.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                rappel = new ModelRappel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6)
                );
            }

        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de la récupération du rappel.");
        } finally {
            try { 
                if (rs != null){
                    rs.close();
                }
                if(pst != null) {
                    pst.close();
                } 
            }catch (SQLException ignorer) {}
        }

        return rappel;
    }

    /**
     * Methode permettant de recuperer tout les rappels présents dans la base de données
     * les trie par odre croissant
     * @return une liste avec les rappels
    */
    
    public List<ModelRappel> getAllRappels() throws SQLException {
        List<ModelRappel> rappels = new ArrayList<>();
        String sql = "SELECT * FROM " + DBManager.TABLE_NAME + " ORDER BY rang ASC";

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = this.connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rappels.add(new ModelRappel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6)
                ));
            }
        } finally {
            try { 
                if (rs != null){
                    rs.close();
                }
                if(pst != null) {
                    pst.close();
                } 
            }catch (SQLException ignorer) {}
        }
        return rappels;
    }

    /**
     * Methode permettant de recuperer le rappel avec le plus haut rang
     * @return int la retourne sous forme d'Integer
    */

    public int getMaxRang() {
        int max = -1;
        String sql = "SELECT MAX(rang) FROM " + DBManager.TABLE_NAME;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = this.connection.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                max = rs.getInt(1);
            } 
        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de la récupération du rang max.");
        } finally {
            try { 
                if (rs != null){
                    rs.close();
                }
                if(pst != null) {
                    pst.close();
                } 
            }catch (SQLException ignorer) {}
        }
        return max;
    }

    /**
     * Methode permettant de mettre à jour le nouveau rang du rappel
     * @param id l'ID du rappel correspondant
     * @param nouveauRang le nouveau rang du rappel correspondant
     */

    public void updateRang(int id, int nouveauRang) {
        String sql = "UPDATE " + DBManager.TABLE_NAME + " SET rang = ? WHERE id = ?";
        PreparedStatement pst = null;
        try {
            pst = this.connection.prepareStatement(sql);
            pst.setInt(1, nouveauRang);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de la mise à jour du rang.");
        } finally {
            try { 
                if(pst != null) {
                    pst.close();
                } 
            }catch (SQLException ignorer) {}
        }
    }

    /**
     * Methode permettant de recupérer un Rappel selon le rang
     * @param rang le rang du Rappel
     * @return ModelRappel retourne un Objet ModelRappel
    */
    
    public ModelRappel getRappelParRang(int rang) {
        String sql = "SELECT * FROM " + DBManager.TABLE_NAME + " WHERE rang = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = this.connection.prepareStatement(sql);
            pst.setInt(1, rang);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new ModelRappel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6)
                );
            }
        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de la récupération par rang.");
        } finally {
            try { 
                if (rs != null){
                    rs.close();
                }
                if(pst != null) {
                    pst.close();
                } 
            }catch (SQLException ignorer) {}
        }
        return null;
    }

    /**
     * Methode permettant de réorganiser les rappels selon leurs rang
     * du plus petit au plus grand
    */
    
    public void reorganiserRangs() {
        String sqlSelect = "SELECT id FROM " + DBManager.TABLE_NAME + " ORDER BY rang ASC";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = this.connection.prepareStatement(sqlSelect);
            rs = pst.executeQuery();
            int nouveauRang = 0;
            while (rs.next()) {
                int id = rs.getInt(1);
                updateRang(id, nouveauRang++);
            }
        } catch (SQLException e) {
            ErrorManager.showError("Erreur lors de la réorganisation des rangs.");
        } finally {
            try { 
                if (rs != null){
                    rs.close();
                }
                if(pst != null) {
                    pst.close();
                } 
            }catch (SQLException ignorer) {}
        }
    }

    /**
    * Methode permettant d'echanger les rangs
    * @param id1   identifiant du premier rappel à échanger
    * @param rang1 rang actuel du premier rappel
    * @param id2   identifiant du second rappel à échanger
    * @param rang2 rang actuel du second rappel
    */

    public void echangerRangs(int id1, int rang1, int id2, int rang2) {
        updateRang(id1, -1); // temp
        updateRang(id2, rang1);
        updateRang(id1, rang2);
    }
}
