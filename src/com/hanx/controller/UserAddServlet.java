package com.hanx.controller;

import com.hanx.dao.UserDAO;
import com.hanx.entity.MessageModel;
import com.hanx.entity.User;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName,userPwd;
        userName = req.getParameter("uname");
        userPwd = req.getParameter("upwd");

        MessageModel messageModel = new MessageModel();
        User user = new User(userName, userPwd);
        messageModel.setUser(user);

        if(UserDAO.findUser(userName) != null){
            messageModel.setCode(0);
            messageModel.setMsg("UserExists");
        } else if(UserDAO.addUser(user) == 1){
            messageModel.setCode(1);
            messageModel.setMsg("AddSuccess");
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
        out.print(new JSONObject(messageModel));
        out.flush();
    }
}
