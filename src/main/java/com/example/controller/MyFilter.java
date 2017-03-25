package com.example.controller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by 王培培 on 2017/3/13.
 */
@WebFilter(filterName="wordFilter",urlPatterns="/*")
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       // System.out.println("执行过滤操作");
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        A a=new A(req);
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
class A extends HttpServletRequestWrapper {
    public A(HttpServletRequest request) {
        super(request);
    }
    @Override //
    public String getParameter(String name) {
        String words = super.getParameter(name);
        System.out.println(words);//过滤前的文字
        try {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("H:\\MeiboCity\\src\\main\\resources\\static\\senseword.xml")));
        StringBuffer sb = new StringBuffer();
        String line = null;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            Document doc = null;
            doc = DocumentHelper.parseText(sb.toString());
            Element root = doc.getRootElement();
            List<Element> list = root.elements();
            for (Element ll : list) {
                String s = ll.getName();
                words = words.replace(s, "*");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }
}