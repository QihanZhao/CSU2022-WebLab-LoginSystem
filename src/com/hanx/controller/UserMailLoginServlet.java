package com.hanx.controller;

import com.hanx.dao.UserDAO;
import com.hanx.entity.MessageModel;
import com.hanx.entity.User;
import com.hanx.util.MailUtil;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mailLogin")
public class UserMailLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userMail = req.getParameter("umail");
        String userCode = req.getParameter("ucode");

        User userToQuery = new User(userMail, userCode);
        MessageModel messageModel = new MessageModel();
        messageModel.setUser(userToQuery);

        String userRealCode = MailUtil.mailCode.get(userMail);

        //用户名错误
        if(userRealCode == null){
            messageModel.setMsg("UserNotExist");
        }
        //密码错误
        else if(!userCode.equals(userRealCode)){
            messageModel.setMsg("WrongCode");
        }
        //登陆成功
        else{
            messageModel.setCode(1);
            messageModel.setMsg("MailLoginSuccess");
            messageModel.setUser(new User(userMail,userRealCode));
            MailUtil.mailCode.remove(userMail);
        }

        Cookie cookie=new Cookie("name",userMail.split("@")[0]);
//        cookie.setMaxAge(1000);
        cookie.setPath(req.getContextPath());
        resp.addCookie(cookie);
        System.out.println(cookie);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
        out.print(new JSONObject(messageModel));
        out.flush();

    }
}