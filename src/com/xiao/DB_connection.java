package com.xiao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xiaoxuhong on 2017/4/23.
 */
public class DB_connection {
    public static Connection link() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        // JDBC 驱动名及数据库 URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/addressbook";

// 数据库的用户名与密码，需要根据自己的设置
        final String USER = "root";
        final String PASS = "";

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }
}
