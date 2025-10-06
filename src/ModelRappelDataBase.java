import java.sql.*;
import java.util.*;

public class ModelRappelDataBase {
    private Connection connection;

    public ModelRappelDataBase(Connection c) { this.connection = c; }

    public void ajouterRappel(ModelRappel r) {}
    public void supprimerRappel(int id) {}
    public void modifierRappel(ModelRappel r) {}
    public List<ModelRappel> getAllRappels() { return null; }
    public ModelRappel getOneRappel(int id) { return null; }
}
