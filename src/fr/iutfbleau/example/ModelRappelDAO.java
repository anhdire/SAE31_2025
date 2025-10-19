package fr.iutfbleau.example;
import java.sql.*;
import java.util.*;

/**
 * Classe permettant d'interagir avec la BD
 */
public class ModelRappelDAO {
    private Connection connection;

    public ModelRappelDAO(Connection c) { 
        this.connection = c; 
    }

    /**
     * Permet d'ajouter le rappel dans la base de données
     * @param r permet de recuper les champs que l'on veut insérer
    */
    public void ajouterRappel(ModelRappel r) {
        String nom = r.getTitre();
        String contenu = r.getContenu();
        int theme = r.getTheme();
        int rang = r.getRang();
        try{
            String sql_request = "INSERT INTO " + DBManager.TABLE_NAME+ " (Titre,Contenu,Theme,Rang)" + "VALUES(?,?,?,?)";
            PreparedStatement requete = this.connection.prepareStatement(sql_request);
            requete.setString(1,nom); // permet d'ajouter le nom du rappel
            requete.setString(2,contenu); // permet d'ajouter le nom du contenu
            requete.setInt(3,theme); // permet d'ajouter le theme du rappel
            requete.setInt(4,rang); // permet d'ajouter le rang du rappel
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
                    rs.getInt(5),
                    rs.getString(6)
                );
                rappels.add(rappel);
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des rappels :");
            e.printStackTrace();
        }
        return rappels; 
    }



    /**
     * Methode permettant de recupérer le rappel du choix par rapport à l'ID
     * @param id permet de recuperer les données seulement d'un rappel
     * @return ModelRappel retourne les données sous forme d'un rappel
    */

    public ModelRappel getOneRappel(int id){
        String title = new String();
        String content = new String();
        int theme = 0;
        int rank = 0;
        String date = new String();
        try{
            String req_sql = "SELECT Titre,Contenu,Theme,Rang,DateCreation FROM "+DBManager.TABLE_NAME+" WHERE Id=(?)";
            PreparedStatement pstate = this.connection.prepareStatement(req_sql);
            pstate.setInt(1,id);
            //pstate.executeQuery();
            ResultSet rset = pstate.executeQuery();
         while(rset.next()){
            title = rset.getString("Titre");
            content = rset.getString("Contenu");
            theme = rset.getInt("Theme");
            rank = rset.getInt("Rang");
            date = rset.getString("DateCreation");
        }
        


        }catch(SQLException e){
            System.out.println("Erreur de requete SQL pour la recherche d'un rappel selon l'ID");
        }

        ModelRappel mod_rap = new ModelRappel(id,title,content,theme,rank,date);
        return mod_rap;


    }
}
