package com.hanx.controller;

import com.hanx.entity.MessageModel;
import com.hanx.entity.User;
import com.hanx.util.MailUtil;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/verify")
public class UserMailVerifyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userMail = req.getParameter("umail");
        String code = MailUtil.generateCode();
        MailUtil.mailCode.put(userMail,code);
        MailUtil.send(userMail,code);

        MessageModel messageModel = new MessageModel();
        if(MailUtil.mailCode.get(userMail) != null){
            messageModel.setCode(1);
            messageModel.setMsg("MailRegisterSuccess");
            messageModel.setUser(new User(userMail,code));
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
        out.print(new JSONObject(messageModel));
        out.flush();
    }
}
