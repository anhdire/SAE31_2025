package fr.iutfbleau.example;

import java.sql.*;
import java.util.*;

public class ModelRappelDAO {
    private Connection connection;

    public ModelRappelDAO(Connection c) { this.connection = c; }

    public void ajouterRappel(ModelRappel r) {}
    public void supprimerRappel(int id) {}
    public void modifierRappel(ModelRappel r) {}
    public List<ModelRappel> getAllRappels() { 
        List<ModelRappel> rappels = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Rappel";
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
