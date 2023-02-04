package login.model;
import exception.ConnectionDBException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private String url = "url";
    private String username = "username";
    private String password = "password";

    private DBConnection() throws ConnectionDBException {
            try
            {this.getDBcredentials();
            this.connection = DriverManager.getConnection(url, username, password);}
            catch(SQLException ex){throw new ConnectionDBException("DB Connection Error");}
            }

    public Connection getConnection() {
        return connection;
    }

    private void getDBcredentials() throws SQLException {
        try{
        FileInputStream propsInput = new FileInputStream("src/main/logic/resources/config.properties");
        Properties prop = new Properties();
        prop.load(propsInput);
        this.url=prop.getProperty("urlDB");
        this.username=prop.getProperty("usernameDB");
        this.password=prop.getProperty("passwordDB");
        propsInput.close();}
        catch(IOException ex) {
            throw new SQLException();}}

    public static DBConnection getInstance() throws SQLException, ConnectionDBException {
        if (instance == null) {
            instance = new DBConnection();

        }
        if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }

        return instance;
    }
}
