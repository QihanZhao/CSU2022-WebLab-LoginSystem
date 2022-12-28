package com.hanx.dao;

import com.hanx.entity.User;
import com.hanx.util.JdbcUtil;
import org.jcp.xml.dsig.internal.SignerOutputStream;

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
    public static List<User> findAll() {

        List<User> list = new ArrayList<>();
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
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setUserPwd(rs.getString("userPwd"));
                list.add(user);

//                System.out.println(rs.getString("userId"));
//                System.out.println(rs.getString("userName"));
//                System.out.println(rs.getString("userPwd"));
//                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.println("数据库查询过程中出现问题...");
        }

        return list;
    }

    public static int addUser(User user){
        int cnt = 0;
        String sql = "insert into tb_user (userName,userPwd)"+
                    "values(?,?)";
        try(
            Connection conn = JdbcUtil.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
        ){
            pstm.setString(1,user.getUserName());
            pstm.setString(2,user.getUserPwd());
            cnt = pstm.executeUpdate();
        } catch(SQLException e) {
            System.out.println("数据库增加过程中出现问题...");
        }
        return cnt;
    }

    public static User findUser(String userName){
        User userQueried = new User();

        // SQL语句
        String sql = "select userName, userPwd from tb_user where userName = " + "'" + userName + "'";

        try (   // 2.创建数据库连接
                Connection conn = JdbcUtil.getConnection();
                // 3.创建语句对象
                PreparedStatement pstm = conn.prepareStatement(sql);
                // 4.执行查询
                ResultSet rs = pstm.executeQuery();
        ){

            // 6. 遍历结果集
            while (rs.next()) {
                userQueried.setUserName(rs.getString("userName"));
                userQueried.setUserPwd(rs.getString("userPwd"));
//                System.out.println(userQueried.getUserName());
//                System.out.println(userQueried.getUserPwd());
            }

        } catch (SQLException e) {
            System.out.println("ERRORHERE...");
        }

        return userQueried;
    }

    public static int deleteByName(String userName) {
        // SQL语句
        int cnt = 0;
        String sql = "delete from tb_user where userName = " + "'" + userName + "'";

        try ( // 2.创建数据库连接
              Connection conn = JdbcUtil.getConnection();
              // 3. 创建语句对象
              PreparedStatement pstm = conn.prepareStatement(sql);
        ) {
            cnt = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("数据库查询过程中出现问题...");
        }
        return cnt;
    }

    public static int updateByName(String userName, String newPwd) {
        // SQL语句
        int cnt = 0;
        String sql = "update tb_user set userPwd = ? where userName = ? ";

        try ( // 2.创建数据库连接
              Connection conn = JdbcUtil.getConnection();
              // 3. 创建语句对象
              PreparedStatement pstm = conn.prepareStatement(sql);
        ) {
            pstm.setString(1,newPwd);
            pstm.setString(2,userName);
            cnt = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("数据库查询过程中出现问题...");
        }
        return cnt;
    }
}
