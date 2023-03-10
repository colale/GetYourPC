package find_pc.model;

import exception.ConnectionDBException;
import login.model.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDesktopDAO {
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
        String query = "SELECT Desktop.*, Users.email, Users.name, Users.surname, PostGeneralInfo.* \n" +
                "FROM PostGeneralInfo \n" +
                "JOIN Users ON Users.id_user = PostGeneralInfo.id_user \n" +
                "JOIN Desktop ON Desktop.id_post = PostGeneralInfo.id_post \n" +
                "WHERE Users.status = 'active' \n" +
                "AND (3959 * acos (cos ( radians(?) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?) ) + sin ( radians(?) ) * sin( radians( latitude ) ))) < ? \n" +
                "AND price BETWEEN ? AND ?;\n";
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

        default: throw new IllegalArgumentException("Invalid code: " + code);
    }}

    public List<Result> setResults(ResultSet rs) throws SQLException {
        List<Result> desktopPostList = new ArrayList<>();
        while (rs.next()) {
            Result post = new ResultDesktop();
            ((ResultDesktop)post).setPrice(rs.getInt("price"));
            ((ResultDesktop)post).setFullAddress(rs.getString("complete_address"));
            ((ResultDesktop)post).setPower(rs.getString("power"));
            ((ResultDesktop)post).setHeatSink(rs.getString("cpu_heat"));
            ((ResultDesktop)post).setPcCase(rs.getString("pc_case"));
            ((ResultDesktop)post).setMotherboard(rs.getString("motherboard"));
            ((ResultDesktop)post).setCpu(rs.getString("cpu"));
            ((ResultDesktop)post).setGpu(rs.getString("gpu"));
            ((ResultDesktop)post).setRam(rs.getString("ram"));
            ((ResultDesktop)post).setMemory(rs.getString("memory"));
            ((ResultDesktop)post).setSellerName(rs.getString("name"));
            ((ResultDesktop)post).setSellerSurname(rs.getString("surname"));
            ((ResultDesktop)post).setSellerEmail(rs.getString("email"));
            ((ResultDesktop) post).setImg1(rs.getBytes("photo1"));
            ((ResultDesktop) post).setImg2(rs.getBytes("photo2"));
            ((ResultDesktop) post).setImg3(rs.getBytes("photo3"));
            desktopPostList.add(post);
        }
        return desktopPostList;
    }
}




