package login.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import login.bean.CredentialsInput;
import login.bean.UserDataBean;

public class SessionDAOdb {
    private Connection connection;
    public SessionDAOdb() throws SQLException{//gestire caso in cui salta la connessione
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public UserDataBean fetchUser(CredentialsInput input) throws SQLException {
        UserDataBean user = null;
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, input.getEmail());
            stmt.setString(2, input.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserDataBean();
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setRole(rs.getString("role"));
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
