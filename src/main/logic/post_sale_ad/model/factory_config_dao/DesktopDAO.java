package post_sale_ad.model.factory_config_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.factory_config_info.Post;
import post_sale_ad.model.factory_config_info.Desktop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DesktopDAO implements PostDAO {
    private Connection connection;

    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public void storePost(Post post) throws SQLException, ConnectionDBException {
        this.getConnection();
        String query = "INSERT INTO DesktopPost (id_user, photo1, photo2, photo3, price, complete_address, latitude, longitude, cpu, motherboard, gpu, ram, memory, power, cpu_heat,pc_case) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
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
        preparedStatement.setString(9, ((Desktop) post).getCpu());
        preparedStatement.setString(10, ((Desktop) post).getMotherboard());
        preparedStatement.setString(11, ((Desktop) post).getGpu());
        preparedStatement.setString(12, ((Desktop) post).getRam());
        preparedStatement.setString(13, ((Desktop) post).getMemory());
        preparedStatement.setString(14, ((Desktop) post).getPower());
        preparedStatement.setString(15, ((Desktop) post).getHeatSink());
        preparedStatement.setString(16, ((Desktop) post).getPcCase());
        preparedStatement.executeUpdate();
    }

    public byte[] convertInBytes(String fullPath) throws ConnectionDBException {
        try {
            return Files.readAllBytes(Paths.get(fullPath));
        } catch (IOException ex) {
            throw new ConnectionDBException("Error reading image file: " + ex.getMessage());
        }
        }
    }