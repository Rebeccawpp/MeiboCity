package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王培培 on 2017/2/12.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/saveinfo")
    public String saveinfo(HttpSession session, HttpServletRequest request){
        User user1=(User)session.getAttribute("user");
        int userid=user1.getId();
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        String realname=request.getParameter("realname");
        user1.setPhone(phone);
        user1.setAddress(address);
        user1.setRealname(realname);
        user1.setEmail(email);
        service.saveinfo(user1);
        System.out.println("add info success!");
        return "tianxiedingluxinxi";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") User user){
        if(service.register(user)>0){
            return "login";
        }
        return "register";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpSession session, HttpServletRequest request){

        if(user.getUsername()==""){
            request.setAttribute("error","用户名不能为空");
            return "login";
        }else if(user.getPassword()==""){
            request.setAttribute("error","密码不能为空");
            return "login";
        }else{
            Map map=new HashMap();
            map.put("username",user.getUsername());
            map.put("password",user.getPassword());
            User user1=service.login(map);
            if(user1!=null){
                session.setAttribute("user",user1);
                return "redirect:/";
            }
            request.setAttribute("error","用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping("/dianpushezhi")
    public String dianpushezhi(HttpSession session){
        return "";
    }

    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
        session.setAttribute("user",null);
        return "index";
    }

    @RequestMapping("/compile")//编辑资料
    public String compile(){//编辑资料
        return "user_message";
    }

    @RequestMapping("/compile_file")
    public String compile_file(@ModelAttribute("user") User user, HttpSession session, ModelMap modelMap,HttpServletRequest request){
        User user1=(User)session.getAttribute("user");
        int id=user1.getId();
        user.setId(id);
        String dir="";
        String path="H:\\MeiboCity\\src\\main\\resources\\static";//该路径为项目所在路径
        try {
            Part p=request.getPart("avatar");
            //  path=path.substring(6);
            String h=p.getHeader("content-disposition");
            String name=p.getSubmittedFileName();
            System.out.println("##"+h);
            System.out.println("####"+name);
            //System.out.println(path) ;
            path=path+"\\avatar";
            File f=new File(path);
            if(!f.exists()){
                f.mkdir();
            }
            p.write(path+"\\"+name);
            dir="avatar\\"+name;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        user.setAvatar(dir);
        if(service.updatefile(user)>0){
            return "manage";
        }
        modelMap.put("up_error","添加信息失败，请重试");
        return "user_message";
    }
}
