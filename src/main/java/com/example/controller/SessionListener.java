package com.example.controller;

/**
 * Created by 王培培 on 2017/3/12.
 */
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        int n = (Integer)session.getServletContext().getAttribute("counter");//创建一个会话就将访问量加一
        session.getServletContext().setAttribute("counter", n+1);
        Properties pro = new Properties();
        try {//访问人数加一后就将结果写入文件（防止不正常关闭服务器）
            pro.setProperty("counter", session.getServletContext().getAttribute("counter").toString());
           // String filePath = se.getSession().getServletContext().getRealPath("/static/1.txt");
            //当前项目所在目录
            String filePath="H:\\MeiboCity\\src\\main\\resources\\static\\1.txt";
            OutputStream os = new FileOutputStream(filePath);
            pro.store(os, null);
        } catch (IOException e) {
            System.out.println("写入计数文件失败");
        }
        System.out.println("Session 被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session 被销毁");
    }
}