package find_pc.model;

import exception.ConnectionDBException;
import login.model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultLaptopDAO {
    private Connection connection;

    public void getConnection() throws SQLException, ConnectionDBException {
        DBConnection db = DBConnection.getInstance();
        this.connection = db.getConnection();
    }

    public List<Result> fetchResults(UserRequest request) throws ConnectionDBException, SQLException {
        double inputLatitude = request.getLatRequest();
        double inputLongitude = request.getLongRequest();
        String distance = request.getDistance();
        int rangeCode = request.getBudgetRange();
        int[] budgetRange = calculateRange(rangeCode);
        double inputDistance = Double.parseDouble(distance);
        getConnection();
        String query = "SELECT LaptopPost.*, Users.email, Users.name, Users.surname "
                + "FROM LaptopPost "
                + "JOIN Users ON LaptopPost.id_user = Users.id_user "
                + "WHERE LaptopPost.status = 'active' "
                + "AND Users.status = 'active' "
                + "AND (3959 * acos (cos ( radians(?) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?) ) + sin ( radians(?) ) * sin( radians( latitude ) ))) < ? "
                + "AND price BETWEEN ? AND ?;";

        PreparedStatement preparedStmt = this.connection.prepareStatement(query);
        preparedStmt.setDouble(1, inputLatitude);
        preparedStmt.setDouble(2, inputLongitude);
        preparedStmt.setDouble(3, inputLatitude);
        preparedStmt.setDouble(4, inputDistance);
        preparedStmt.setInt(5, budgetRange[0]);
        preparedStmt.setInt(6, budgetRange[1]);
        ResultSet rs = preparedStmt.executeQuery();
        return setResults(rs);
    }

    public int[] calculateRange(int code) {
        switch (code) {
            case 1:
                int[] range1 = {0, 400};
                return range1;
            case 2:
                int[] range2 = {400, 600};
                return range2;

            case 3:
                int[] range3 = {600, 1000};
                return range3;

            case 4:
                int[] range4 = {1000, Integer.MAX_VALUE};
                return range4;

        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    public List<Result> setResults(ResultSet rs) throws SQLException {
        List<Result> laptopPostList = new ArrayList<>();
        while (rs.next()) {
            Result post = new ResultLaptop();
            ((ResultLaptop)post).setPostId(rs.getInt("id_post"));
            ((ResultLaptop) post).setSellerId(rs.getInt("id_user"));
            ((ResultLaptop) post).setPrice(rs.getInt("price"));
            ((ResultLaptop) post).setFullAddress(rs.getString("complete_address"));
            ((ResultLaptop)post).setLatitude(rs.getDouble("latitude"));
            ((ResultLaptop)post).setLongitude(rs.getDouble("longitude"));
            ((ResultLaptop)post).setBrand(rs.getString("brand"));
            ((ResultLaptop) post).setModel(rs.getString("model"));
            ((ResultLaptop)post).setScreenSize(rs.getDouble("screen_size"));
            ((ResultLaptop)post).setCpu(rs.getString("cpu"));
            ((ResultLaptop)post).setGpu(rs.getString("gpu"));
            ((ResultLaptop)post).setRam(rs.getString("ram"));
            ((ResultLaptop)post).setMemory(rs.getString("memory"));
            ((ResultLaptop)post).setSellerName(rs.getString("name"));
            ((ResultLaptop)post).setSellerSurname(rs.getString("surname"));
            ((ResultLaptop) post).setSellerEmail(rs.getString("email"));
            laptopPostList.add(post);
        }
        return laptopPostList;
    }
}




