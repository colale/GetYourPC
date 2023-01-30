package login.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/Database";
    private String username = "root";
    private String password = "colantonidb";

    private DBConnection() throws SQLException {
            this.connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();

        }
        if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }

        return instance;
    }
}
