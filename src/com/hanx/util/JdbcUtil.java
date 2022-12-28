package com.hanx.util;

import java.sql.*;

public class JdbcUtil {

    // 连接数据库url
    // static String url = "jdbc:mysql://mysql.sqlpub.com:3306/chatroom?serverTimezone=UTC";
    // static String user = "hanxdb";
    // static String password = "63ad30bb62e1ac95";
    static final String url = "jdbc:mysql://localhost:3306/logincsu?serverTimezone=UTC";
    static final String user = "root";
    static final String password = "12345";

    // 驱动程序加载
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动程序加载成功...");

        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
        }
    }

    // 创建数据库连接
    public static Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("DB CONNECTION SUCCESS: " + conn);
        return conn;
    }


}
