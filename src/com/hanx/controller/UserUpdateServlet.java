package com.hanx.controller;

import com.hanx.dao.UserDAO;
import com.hanx.util.MessageModel;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName;
        String newPwd;
        userName = req.getParameter("uname");
        newPwd = req.getParameter("newpwd");

        MessageModel messageModel = new MessageModel();

        int cnt = UserDAO.updateByName(userName, newPwd);

        //用户名错误
        if(cnt == 1){
            messageModel.setCode(1);
            messageModel.setMsg("Success");
            messageModel.setUser(1);
        }

        JSONObject jsonObject = new JSONObject(messageModel);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        out.print(jsonObject);
        out.flush();
    }
}