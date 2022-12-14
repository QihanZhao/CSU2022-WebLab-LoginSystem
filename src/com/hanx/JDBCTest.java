package com.hanx;

import com.hanx.dao.UserDAO;

public class JDBCTest {
    public static void main(String[] args) {
        int cnt = UserDAO.findAll();
        String show = cnt==0 ? "fail" : "success";
        System.out.println(show);
    }
}
