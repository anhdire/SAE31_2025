package fr.iutfbleau.example;

import java.sql.*;
import java.util.*;

public class ModelRappelDataBase {
    private Connection connection;

    public ModelRappelDataBase(Connection c) { this.connection = c; }

    public void ajouterRappel(ModelRappel r) {}
    public void supprimerRappel(int id) {}
    public void modifierRappel(ModelRappel r) {}
    public List<ModelRappel> getAllRappels() { 
        List<ModelRappel> rappels = new ArrayList<>();
        ModelRappel rappel;
        try {
            String sql = "SELECT * FROM Rappel";
            PreparedStatement pst = this.connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                rappel = new ModelRappel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5)
                );


            }

        } catch (SQLException e) {
        }
        return null; 
    }
    public ModelRappel getOneRappel(int id) { return null; }
}
