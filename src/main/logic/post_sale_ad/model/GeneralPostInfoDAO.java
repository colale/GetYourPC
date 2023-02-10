package post_sale_ad.model;

import exception.ConnectionDBException;
import login.model.DBConnection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class GeneralPostInfoDAO {
    private Connection connection;
    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public void storeGeneralPostInfo(Post post) throws ConnectionDBException, SQLException {//scrive le general info sul db e setta l'id del post
        this.getConnection();
        String query="INSERT INTO PostGeneralInfo (id_user, photo1, photo2, photo3, price, complete_address, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, post.getGeneralPostInfo().getSellerId());
        String imagePath1 = post.getGeneralPostInfo().getImg1();
        String imagePath2 = post.getGeneralPostInfo().getImg2();
        String imagePath3 = post.getGeneralPostInfo().getImg3();
        stmt.setBytes(2, convertInBytes(imagePath1));
        stmt.setBytes(3, convertInBytes(imagePath2));
        stmt.setBytes(4, convertInBytes(imagePath3));
        stmt.setInt(5, post.getGeneralPostInfo().getPrice());
        stmt.setString(6, post.getGeneralPostInfo().getFullAddress());
        stmt.setDouble(7, post.getGeneralPostInfo().getLatitude());
        stmt.setDouble(8, post.getGeneralPostInfo().getLongitude());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
        post.setPostId(rs.getInt(1));}
        else throw new SQLException();}

        public byte[] convertInBytes(String fullPath) throws ConnectionDBException {
        try {//fetch img from path and converts it in bytes
            return Files.readAllBytes(Paths.get(fullPath));
        } catch (IOException ex) {
            throw new ConnectionDBException("Error reading image file: " + ex.getMessage());
        }
    }
}