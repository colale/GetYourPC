package post_sale_ad.model.factory_config_info_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.factory_config_info.DesktopInfo;
import post_sale_ad.model.factory_config_info.PcInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DesktopDAO implements PcInfoDAO {
    private Connection connection;

    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public void storePcInfo(int id,PcInfo pcInfo) throws SQLException, ConnectionDBException {
        this.getConnection();
        DesktopInfo desktopInfo=(DesktopInfo) pcInfo;
        String query = "INSERT INTO Desktop(id_post,cpu, motherboard, gpu, ram, memory, power, cpu_heat,pc_case) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2,  desktopInfo.getCpu());
        preparedStatement.setString(3, desktopInfo.getMotherboard());
        preparedStatement.setString(4, desktopInfo.getGpu());
        preparedStatement.setString(5, desktopInfo.getRam());
        preparedStatement.setString(6, desktopInfo.getMemory());
        preparedStatement.setString(7, desktopInfo.getPower());
        preparedStatement.setString(8, desktopInfo.getHeatSink());
        preparedStatement.setString(9, desktopInfo.getPcCase());
        preparedStatement.executeUpdate();
    }
}
