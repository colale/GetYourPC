package post_sale_ad.model.factory_config_info_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.Post;
import post_sale_ad.model.factory_config_info.LaptopInfo;
import post_sale_ad.model.factory_config_info.PcInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaptopDAO implements PcInfoDAO {
    private Connection connection;

    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public void storePcInfo(int id,PcInfo pcInfo) throws SQLException, ConnectionDBException {
        this.getConnection();//Cambiare la query mettendo where id=inputdato e restituire
        LaptopInfo laptopInfo=(LaptopInfo)pcInfo;
        String query = "INSERT INTO LaptopPost (id_user, photo1, photo2, photo3, price, complete_address, latitude, longitude, brand, model, screen_size, cpu, gpu, ram, memory) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(9, laptopInfo.getBrand());
        preparedStatement.setString(10,laptopInfo.getModel());
        preparedStatement.setDouble(11,laptopInfo.getScreenSize());
        preparedStatement.setString(12,laptopInfo.getCpu());
        preparedStatement.setString(13,laptopInfo.getGpu());
        preparedStatement.setString(14,laptopInfo.getRam());
        preparedStatement.setString(15,laptopInfo.getMemory());
        preparedStatement.executeUpdate();
    }
}
/*

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
                */

    /*
        */


/*
    public byte[] convertInBytes(String fullPath) throws ConnectionDBException {
        try {//fetch img from path and converts it in bytes
            return Files.readAllBytes(Paths.get(fullPath));
        } catch (IOException ex) {
            throw new ConnectionDBException("Error reading image file: " + ex.getMessage());
        }
    }
}
*/