package post_sale_ad.model.factory_config_info_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
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
        this.getConnection();
        LaptopInfo laptopInfo = (LaptopInfo) pcInfo;
        String query = "INSERT INTO Laptop (id_post, brand, model, screen_size, cpu, gpu, ram, memory) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, laptopInfo.getBrand());
        preparedStatement.setString(3, laptopInfo.getModel());
        preparedStatement.setDouble(4, laptopInfo.getScreenSize());
        preparedStatement.setString(5, laptopInfo.getCpu());
        preparedStatement.setString(6, laptopInfo.getGpu());
        preparedStatement.setString(7, laptopInfo.getRam());
        preparedStatement.setString(8, laptopInfo.getMemory());
        preparedStatement.executeUpdate();
    }    }