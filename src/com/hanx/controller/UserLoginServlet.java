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

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName,userPwd;
        userName = req.getParameter("uname");
        userPwd = req.getParameter("upwd");
        User userToQuery = new User(userName, userPwd);

        MessageModel messageModel = new MessageModel();
        messageModel.setOject(userToQuery);

        User userQueried = UserDAO.loginUser(userToQuery);
//        String show = cnt==0 ? "fail" : "success";

        //用户名错误
        if(userQueried == null){
            messageModel.setMsg("UserNotExist");
        }
        //密码错误
        else if(!userPwd.equals(userQueried.getUserPwd())){
            messageModel.setMsg("WrongPassWord");
        }
        //登陆成功
        else{
            messageModel.setOject(userQueried);
        }

        JSONObject jsonObject = new JSONObject(messageModel);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        out.print(jsonObject);
        out.flush();
    }
}