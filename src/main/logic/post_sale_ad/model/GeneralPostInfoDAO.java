package post_sale_ad.model;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.factory_config_info.PcInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

public class GeneralPostInfoDAO {
    private Connection connection;
    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public void storeGeneralPostInfo(Post post) {//scrive le general info sul db e setta l'id del post
//query ecc

        preparedStatement.setInt(1, pcInfo.getGeneralPostInfo().getSellerId());
        String imagePath1 = pcInfo.getGeneralPostInfo().getImg1();
        String imagePath2 = pcInfo.getGeneralPostInfo().getImg2();
        String imagePath3 = pcInfo.getGeneralPostInfo().getImg3();
        preparedStatement.setBytes(2, convertInBytes(imagePath1));
        preparedStatement.setBytes(3, convertInBytes(imagePath2));
        preparedStatement.setBytes(4, convertInBytes(imagePath3));
        preparedStatement.setInt(5, pcInfo.getGeneralPostInfo().getPrice());
        preparedStatement.setString(6, pcInfo.getGeneralPostInfo().getFullAddress());
        preparedStatement.setDouble(7, pcInfo.getGeneralPostInfo().getLatitude());
        preparedStatement.setDouble(8, pcInfo.getGeneralPostInfo().getLongitude());
        //prende il post id e lo setta a
    }

    public byte[] convertInBytes(String fullPath) throws ConnectionDBException {
        try {//fetch img from path and converts it in bytes
            return Files.readAllBytes(Paths.get(fullPath));
        } catch (IOException ex) {
            throw new ConnectionDBException("Error reading image file: " + ex.getMessage());
        }
    }
}
