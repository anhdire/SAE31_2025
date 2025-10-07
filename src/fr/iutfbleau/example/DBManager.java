package dialloa.
public class DBManager {

    private static final String URL = "jdbc:mysql://";
    private static final String LOGIN = "dialloa";
    private static final String MDP = "";
    private java.sql.Connection connection;

    public DBManager() {
        this.connection = 
    }

    public java.sql.Connection getConnection() { return connection; }
    public void closeConnection() {}
}
