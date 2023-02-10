package post_sale_ad.model.factory_config_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.factory_config_info.Post;
import post_sale_ad.model.factory_config_info.Laptop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaptopDAO implements PostDAO {
    private Connection connection;

    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public void storePost(Post post) throws SQLException, FileNotFoundException, ConnectionDBException {
        this.getConnection();
        String query = "INSERT INTO LaptopPost (id_user, photo1, photo2, photo3, price, complete_address, latitude, longitude, brand, model, screen_size, cpu, gpu, ram, memory) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, post.getGeneralPostInfo().getSellerId());
        String imagePath1 = post.getGeneralPostInfo().getImg1();
        String imagePath2 = post.getGeneralPostInfo().getImg2();
        String imagePath3 = post.getGeneralPostInfo().getImg3();
        preparedStatement.setBytes(2, convertInBytes(imagePath1));
        preparedStatement.setBytes(3, convertInBytes(imagePath2));
        preparedStatement.setBytes(4, convertInBytes(imagePath3));
        preparedStatement.setInt(5, post.getGeneralPostInfo().getPrice());
        preparedStatement.setString(6, post.getGeneralPostInfo().getFullAddress());
        preparedStatement.setDouble(7, post.getGeneralPostInfo().getLatitude());
        preparedStatement.setDouble(8, post.getGeneralPostInfo().getLongitude());
        preparedStatement.setString(9, ((Laptop) post).getBrand());
        preparedStatement.setString(10, ((Laptop) post).getModel());
        preparedStatement.setDouble(11, ((Laptop) post).getScreenSize());
        preparedStatement.setString(12, ((Laptop) post).getCpu());
        preparedStatement.setString(13, ((Laptop) post).getGpu());
        preparedStatement.setString(14, ((Laptop) post).getRam());
        preparedStatement.setString(15, ((Laptop) post).getMemory());
        preparedStatement.executeUpdate();
    }

    public byte[] convertInBytes(String fullPath) throws ConnectionDBException {
        try {//fetch img from path and converts it in bytes
            return Files.readAllBytes(Paths.get(fullPath));
        } catch (IOException ex) {
            throw new ConnectionDBException("Error reading image file: " + ex.getMessage());
        }
    }
}