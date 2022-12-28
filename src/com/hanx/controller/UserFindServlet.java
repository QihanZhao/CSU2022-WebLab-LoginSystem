package com.hanx.controller;

import com.hanx.dao.UserDAO;
import com.hanx.entity.User;
import com.hanx.util.MessageModel;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find")
public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName;
        userName = req.getParameter("uname");

        MessageModel messageModel = new MessageModel();

        User userQueried = UserDAO.findUser(userName);

        //查询不到
        if(userQueried == null){
            messageModel.setMsg("UserNotExist");
        }
        else{
            messageModel.setCode(1);
            messageModel.setMsg("Success");
            messageModel.setUser(userQueried);
        }

        JSONObject jsonObject = new JSONObject(messageModel);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        out.print(jsonObject);
        out.flush();
    }
}