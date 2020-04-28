package com.rec.spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DeleteFromMySQL implements MySqlConnect {

    public static void delete(int userId) throws SQLException {
        System.out.println("进入 DeleteFromMySQL");
        Properties prop = new Properties();
        prop.setProperty("user", MySqlConnect.user);
        prop.setProperty("password", MySqlConnect.password);

        String sql = "delete from recommendresult where userid=" + userId;
        Connection conn = DriverManager.getConnection(MySqlConnect.url, prop);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();

        if (ps.equals(null)) {
            ps.close();
        }
        if (conn.equals(null)) {
            conn.close();
        }
    }
}

