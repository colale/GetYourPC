package post_sale_ad.model.factory_config_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.factory_config_info.ConfigInfo;
import post_sale_ad.model.factory_config_info.LaptopInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaptopInfoDAO implements ConfigInfoDAO {
    private Connection connection;

    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public void storePost(ConfigInfo configInfo) throws SQLException, FileNotFoundException, ConnectionDBException {
        this.getConnection();
        String query = "INSERT INTO LaptopPost (id_user, photo1, photo2, photo3, price, complete_address, latitude, longitude, brand, model, screen_size, cpu, gpu, ram, memory) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, configInfo.getGeneralPostInfo().getSellerId());
        String imagePath1 = configInfo.getGeneralPostInfo().getImg1();
        String imagePath2 = configInfo.getGeneralPostInfo().getImg2();
        String imagePath3 = configInfo.getGeneralPostInfo().getImg3();
        preparedStatement.setBytes(2, convertInBytes(imagePath1));
        preparedStatement.setBytes(3, convertInBytes(imagePath2));
        preparedStatement.setBytes(4, convertInBytes(imagePath3));
        preparedStatement.setInt(5, configInfo.getGeneralPostInfo().getPrice());
        preparedStatement.setString(6, configInfo.getGeneralPostInfo().getFullAddress());
        preparedStatement.setDouble(7, configInfo.getGeneralPostInfo().getLatitude());
        preparedStatement.setDouble(8, configInfo.getGeneralPostInfo().getLongitude());
        preparedStatement.setString(9, ((LaptopInfo) configInfo).getBrand());
        preparedStatement.setString(10, ((LaptopInfo) configInfo).getModel());
        preparedStatement.setDouble(11, ((LaptopInfo) configInfo).getScreenSize());
        preparedStatement.setString(12, ((LaptopInfo) configInfo).getCpu());
        preparedStatement.setString(13, ((LaptopInfo) configInfo).getGpu());
        preparedStatement.setString(14, ((LaptopInfo) configInfo).getRam());
        preparedStatement.setString(15, ((LaptopInfo) configInfo).getMemory());
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