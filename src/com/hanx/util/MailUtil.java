package com.hanx.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailUtil {

    public static Map<String,String> mailCode = new HashMap<String,String>();

    public static String generateCode(){
        Random random = new Random();
        String result="";
        for (int i=0;i<4;i++)
        {
            result+=random.nextInt(10);
        }
        return result;
    }

    public static void send(String to, String code)
    {
        // 收件人电子邮箱 to
        // 发件人电子邮箱
        String from = "1774003885@qq.com";
        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {   //发件人邮件用户名、授权码
                return new PasswordAuthentication("1774003885@qq.com", "mbeogekabywicehh");
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("CSU登陆验证");
            // 设置消息体
            message.setText("您的验证码是："+code);

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
