package JDSpider.dao;

import java.sql.*;

/**
 * Created by lenovo on 2017/3/27.
 */
public class DBconnection {
    Connection conn;
    PreparedStatement stat;

    private DBconnection() {
        // load the jdbc_mysql driver
        try {
            Class.forName(DBconfiguration.driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("mysql driver cannot be found!");
            e.printStackTrace();
        }

        // connect to db,and get a conn object
        try {
            conn = DriverManager.getConnection(DBconfiguration.url, DBconfiguration.username, DBconfiguration.password);
        } catch (SQLException e) {
            System.out.println("cannot connect to db!");
            e.printStackTrace();
        }
        if (conn != null)
            System.out.printf("connect to db successfully:%n url=%s", DBconfiguration.url);
    }

    private static final DBconnection dBconnection = new DBconnection();
    //静态工厂模式
    public synchronized static Connection getConnection() {
        return dBconnection.conn;
    }
}
