package com.hanx.controller;

import com.hanx.dao.UserDAO;
import com.hanx.entity.User;
import com.hanx.entity.MessageModel;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/manage")
public class UserFindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MessageModel messageModel = new MessageModel();

        System.out.println("server-all");

        List<User> users = UserDAO.findAll();

        //用户名错误
        if(users.isEmpty()){
            messageModel.setMsg("No User");
        }
        //登陆成功
        else{
            messageModel.setCode(1);
            messageModel.setMsg("Success");
            messageModel.setUser(users);
        }

        JSONObject jsonObject = new JSONObject(messageModel);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        out.print(jsonObject);
        out.flush();
    }
}