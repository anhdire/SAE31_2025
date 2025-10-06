public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/papillon";
    private static final String LOGIN = "root";
    private static final String MDP = "";
    private java.sql.Connection connection;

    public DBManager() {}

    public java.sql.Connection getConnection() { return connection; }
    public void closeConnection() {}
}
