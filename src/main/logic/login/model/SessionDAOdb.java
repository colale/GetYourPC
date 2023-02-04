package login.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.ConnectionDBException;
import login.bean.CredentialsInput;

public class SessionDAOdb {
    private Connection connection;
    public SessionDAOdb() throws SQLException, ConnectionDBException {//gestire caso in cui salta la connessione
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public Account fetchUser(CredentialsInput input) throws SQLException {
        Account user = null;
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, input.getEmail());
            stmt.setString(2, input.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new Account();
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setRole(rs.getString("role"));
                int id = Integer.parseInt(rs.getString("id_user"));
                user.setUserID(id);
            }
            rs.close();
            stmt.close();
        return user;
    }
    public void insertAccount(Account account) throws SQLException {
        String sql = "INSERT INTO Users (name, surname, role, email, password)VALUES (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, account.getName());
        stmt.setString(2, account.getSurname());
        stmt.setString(3, account.getRole());
        stmt.setString(4, account.getEmail());
        stmt.setString(5, account.getPassword());
        stmt.executeUpdate();
        stmt.close();
    }
}
