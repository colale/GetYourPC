package post_sale_ad.model.factory_config_info_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.Post;
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
        this.getConnection();//Cambiare la query mettendo where id=inputdato
        DesktopInfo desktopInfo=(DesktopInfo) pcInfo;
        String query = "INSERT INTO DesktopPost (id_user, photo1, photo2, photo3, price, complete_address, latitude, longitude, cpu, motherboard, gpu, ram, memory, power, cpu_heat,pc_case) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(9,  desktopInfo.getCpu());
        preparedStatement.setString(10, desktopInfo.getMotherboard());
        preparedStatement.setString(11, desktopInfo.getGpu());
        preparedStatement.setString(12, desktopInfo.getRam());
        preparedStatement.setString(13, desktopInfo.getMemory());
        preparedStatement.setString(14, desktopInfo.getPower());
        preparedStatement.setString(15, desktopInfo.getHeatSink());
        preparedStatement.setString(16, desktopInfo.getPcCase());
        preparedStatement.executeUpdate();
    }

}
