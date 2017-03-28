package JDSpider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lenovo on 2017/3/27.
 */
public class DBModel {

    public static boolean insertToDB(String name, String number, String url, String pictureSrc,
                                     String detail, double price, int commentCount, double goodRate) {
        final String sql = "insert into commodity" +
                "(name,number,url,pictureSrc,detail,price,commentCount,goodRate)" +
                " values(?,?,?,?,?,?,?,?)";
        Connection conn = DBconnection.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        int changes = 0;
        if (conn == null) {
            return false;
        }
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, number);
            stat.setString(3, url);
            stat.setString(4, pictureSrc);
            stat.setString(5, detail);
            stat.setDouble(6, price);
            stat.setInt(7, commentCount);
            stat.setDouble(8, goodRate);
            changes=stat.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return changes != 0;
    }
}
