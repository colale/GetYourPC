package login.model;

import login.bean.CredentialsInput;
import login.bean.UserDataBean;

public class SessionDAOdb {
    private Connection conn;
    public SessionDAOdb(Connection conn) {
        this.conn = conn;
    }

    public UserDataBean login(CredentialsInput input) {
        UserDataBean user = null;
        try {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, input.getEmail());
            stmt.setString(2, input.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserBean();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setLastname(rs.getString("lastname"));
                user.setActive(rs.getInt("active"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
