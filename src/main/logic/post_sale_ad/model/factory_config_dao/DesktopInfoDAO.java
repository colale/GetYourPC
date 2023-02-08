package post_sale_ad.model.factory_config_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.factory_config_info.ConfigInfo;
import post_sale_ad.model.factory_config_info.DesktopInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DesktopInfoDAO implements ConfigInfoDAO {
    private Connection connection;

    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public void storePost(ConfigInfo configInfo) throws SQLException, ConnectionDBException {
        this.getConnection();
        String query = "INSERT INTO DesktopPost (id_user, photo1, photo2, photo3, price, complete_address, latitude, longitude, cpu, motherboard, gpu, ram, memory, power, cpu_heat,pc_case) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
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
        preparedStatement.setString(9, ((DesktopInfo) configInfo).getCpu());
        preparedStatement.setString(10, ((DesktopInfo) configInfo).getMotherboard());
        preparedStatement.setString(11, ((DesktopInfo) configInfo).getGpu());
        preparedStatement.setString(12, ((DesktopInfo) configInfo).getRam());
        preparedStatement.setString(13, ((DesktopInfo) configInfo).getMemory());
        preparedStatement.setString(14, ((DesktopInfo) configInfo).getPower());
        preparedStatement.setString(15, ((DesktopInfo) configInfo).getHeatSink());
        preparedStatement.setString(16, ((DesktopInfo) configInfo).getPcCase());
        preparedStatement.executeUpdate();
    }

    public byte[] convertInBytes(String fullPath) throws ConnectionDBException {
        try {
            File imageFile = new File(fullPath);
            byte[] imageData = new byte[(int) imageFile.length()];
            FileInputStream inputStream = new FileInputStream(imageFile);
            inputStream.read(imageData);
            inputStream.close();
            return imageData;
        } catch (IOException ex) {
            throw  new ConnectionDBException("Error in the full path of the image, the system cannot save it in the database");
        }
    }
}