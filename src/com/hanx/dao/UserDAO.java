package com.hanx.dao;

import com.hanx.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    // 查询所有用户信息
    public static int findAll() {

//        List<Map<String, String>> list = new ArrayList<>();
        int cnt = 0;
        // SQL语句
        String sql = "select userID, userName, userPwd from tb_user";

        try (   // 2.创建数据库连接
                Connection conn = JdbcUtil.getConnection();
                // 3.创建语句对象
                PreparedStatement pstm = conn.prepareStatement(sql);
                // 4.执行查询
                ResultSet rs = pstm.executeQuery();) {

            // 6. 遍历结果集
            while (rs.next()) {

//                Map<String, String> row = new HashMap<>();
                System.out.println(rs.getString("userId"));
                System.out.println(rs.getString("userName"));
                System.out.println(rs.getString("userPwd"));
                System.out.println("");

                cnt++;
            }

        } catch (SQLException e) {
            System.out.println("数据库查询过程中出现问题...");
        }

        return cnt;
    }
}
