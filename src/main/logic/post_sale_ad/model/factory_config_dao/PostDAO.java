package post_sale_ad.model.factory_config_dao;

import exception.ConnectionDBException;
import post_sale_ad.model.factory_config_info.Post;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface PostDAO {
    public void storePost(Post post) throws SQLException, FileNotFoundException, ConnectionDBException;
}
