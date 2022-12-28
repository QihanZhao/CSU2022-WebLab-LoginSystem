package com.hanx;

import com.hanx.entity.User;
import org.json.JSONObject;

import java.util.Random;

public class JSONTest{
    public static void main(String[] args) {
        User user = new User("hello","pwdddd");

        //Java对象转化为JSON对象
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("Java对象转化为JSON对象\n" + jsonObject);//{"name":"张三","age":18,"sex":"男"}


        Random random = new Random();
        String result="";
        for (int i=0;i<4;i++)
        {
            result+=random.nextInt(10);
        }
        System.out.println(result);

    }
}