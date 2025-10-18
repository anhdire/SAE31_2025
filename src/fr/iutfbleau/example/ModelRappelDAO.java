package fr.iutfbleau.example;
import java.sql.*;
import java.util.*;

/**
 * Classe permettant d'interagir avec la BD
 */
public class ModelRappelDAO {
    private Connection connection;

    public ModelRappelDAO(Connection c) { this.connection = c; }

    /**
     * Permet d'ajouter le rappel dans la base de données
     * @param r permet de recuper les champs que l'on veut insérer
    */
    public void ajouterRappel(ModelRappel r) {
        int id = r.getId();
        String nom = r.getTitre();
        String contenu = r.getContenu();
        int theme = r.getTheme();
        int rang = r.getRang();
        try{
            String sql_request = "INSERT INTO " + DBManager.TABLE_NAME+"(Id,Titre,Contenu,Theme,Rang)" + "VALUES(?,?,?,?,?)";
            PreparedStatement requete = this.connection.prepareStatement(sql_request);
            requete.setInt(1,id);
            requete.setString(2,nom); // permet d'ajouter le nom du rappel
            requete.setString(3,contenu); // permet d'ajouter le nom du contenu
            requete.setInt(4,theme); // permet d'ajouter le theme du rappel
            requete.setInt(5,rang); // permet d'ajouter le rang du rappel
            requete.executeUpdate();
            


        }catch(SQLException e){
            System.out.println("Erreur de requete SQL");
        }
    }
    public void supprimerRappel(int id) {}
    public void modifierRappel(ModelRappel r) {}
    

    public List<ModelRappel> getAllRappels() { 
        List<ModelRappel> rappels = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + DBManager.TABLE_NAME;
            PreparedStatement pst = this.connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                ModelRappel rappel = new ModelRappel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5)
                );
                rappels.add(rappel);
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des rappels :");
            e.printStackTrace();
        }
        return rappels; 
    }

    public ModelRappel getOneRappel(int id) { return null; }
}
