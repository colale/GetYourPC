package post_sale_ad.model.factory_config_dao;

import exception.ConnectionDBException;
import post_sale_ad.model.factory_config_info.ConfigInfo;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface ConfigInfoDAO {
    public void storePost(ConfigInfo configInfo) throws SQLException, FileNotFoundException, ConnectionDBException;
}
