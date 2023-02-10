package post_sale_ad.model.factory_config_info_dao;

import exception.ConnectionDBException;
import post_sale_ad.model.factory_config_info.PcInfo;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface PcInfoDAO {
    public void storePcInfo(int id,PcInfo pcInfo) throws SQLException, FileNotFoundException, ConnectionDBException;//returns post id
}
