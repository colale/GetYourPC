package post_sale_ad.model.factory_config_dao;

import exception.ConnectionDBException;
import login.model.DBConnection;
import post_sale_ad.model.factory_config_info.ConfigInfo;

import java.sql.Connection;
import java.sql.SQLException;

public class DesktopInfoDAO implements ConfigInfoDAO{//QUESTO!!!!!!!!!!!!!!!!!
    private Connection connection;
    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }
    public void storePost(ConfigInfo configInfo){
    }


}



