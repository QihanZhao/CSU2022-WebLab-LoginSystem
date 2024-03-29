package com.hanx.controller;

import com.hanx.dao.UserDAO;
import com.hanx.entity.MessageModel;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName;
        userName = req.getParameter("uname");

        MessageModel messageModel = new MessageModel();

        int cnt = UserDAO.deleteByName(userName);

        if(cnt == 1){
            messageModel.setCode(1);
            messageModel.setMsg("DeleteSuccess");
            messageModel.setUser(1);
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
        out.print(new JSONObject(messageModel));
        out.flush();
    }
}