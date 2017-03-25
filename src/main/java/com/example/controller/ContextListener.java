package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Properties;

/**
 * Created by 王培培 on 2017/3/12.
 */
@WebListener
public class ContextListener implements ServletContextListener {
    String n = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext初始化");
        System.out.println(sce.getServletContext().getServerInfo());
        Properties pro = new Properties();
        //InputStream in = ContextListener.class.getResourceAsStream("H:\\MeiboCity\\src\\main\\resources\\static\\1.txt");
        InputStream in = ContextListener.class.getResourceAsStream("/static/1.txt");
        try {
            pro.load(in);
            n = pro.getProperty("counter");//从计数文件中读取该站的历史访问量
            sce.getServletContext().setAttribute("counter", Integer.parseInt(pro.getProperty("counter")));
        } catch (IOException e) {
            System.out.println("读取计数文件失败");
        }
        System.out.println("创建上下文对象" + n);
    }
    public int getCounter(HttpSession session){
        session.setAttribute("counter",n);
        return Integer.parseInt(n);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("ServletContext销毁");
        Properties pro = new Properties();
        try {
            pro.setProperty("counter", sce.getServletContext().getAttribute(("counter")).toString());
            String filePath = sce.getServletContext().getRealPath("/static/1.txt");
            //上下文对象销毁时，将当前访问量写入文件
            OutputStream os = new FileOutputStream(filePath);
            pro.store(os, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
