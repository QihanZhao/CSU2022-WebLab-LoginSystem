package com.hanx.controller;

import com.hanx.dao.UserDAO;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sr1")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cnt = UserDAO.findAll();
        String show = cnt==0 ? "fail" : "success";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",show);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(jsonObject);
        out.flush();
    }
}
