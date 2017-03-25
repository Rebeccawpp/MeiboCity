package com.example.controller;

import com.example.model.Info;
import com.example.model.User;
import com.example.service.InfoService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王培培 on 2017/2/21.
 */
@Controller
@RequestMapping("info")
public class InfoController {
    @Autowired
    private InfoService service;

    @Autowired
    private UserService uservice;

    @RequestMapping("/detail/{info_id}")
    public String info_detail(@PathVariable("info_id")String info_id,HttpSession session){
        int id=Integer.parseInt(info_id);
        Info info=service.select_info(id);
        session.setAttribute("info",info);
        return "info_detail";
    }

    @RequestMapping("/all_notice")
    public String info_all(HttpSession session){
        List<Info> allnotice=service.select_all_notice();
        session.setAttribute("allnotice",allnotice);
        return "info_all_notice";
    }

    @RequestMapping("/all_empl")
    public String info_all_empl(HttpSession session){
        List<Info> allempl=service.select_all_empl();
        session.setAttribute("allempl",allempl);
        return "info_all_empl";
    }

    @RequestMapping("/post")
    public String info_post(){
        return "info_post";
    }

    @RequestMapping("/manage/{page}/{flag}")
    public String info_manage(@PathVariable("page")String page,
                                @PathVariable("flag")String flag,
                              HttpSession session){
        int countn=service.count(0);
        int counte=service.count(1);
        int pagen=(countn%10==0)?(countn/10):(countn/10+1);
        int pagee=(counte%5==0)?(counte/5):(counte/5+1);
        session.setAttribute("pagen",pagen);
        session.setAttribute("pagee",pagee);
        service.select(page,flag,session);
        return "info_manage";
    }

    @RequestMapping("/add_notice")
    public String addNotice(@ModelAttribute("info") Info info,HttpSession session,
                            HttpServletRequest request){
        info.setInfoDate(new Date(System.currentTimeMillis()));
        info.setFlag(0);
        User user=(User)session.getAttribute("user");
        int userid=user.getId();
        if(uservice.getInfo_num(userid)>0){
            uservice.updatenum(userid);
            info.setUserid(userid);
            if(service.addInfo(info)>0){
                session.setAttribute("error","添加成功");
            }else{
                session.setAttribute("error","添加失败");
            }
        }else{
            session.setAttribute("error","您的发布次数已用尽，请升级为高级会员");
        }
        return "info_post";
    }

    @RequestMapping("/add_empl")
    public String addEmpl(@ModelAttribute("info") Info info, HttpSession session,
                          HttpServletRequest request){
        info.setInfoDate(new Date(System.currentTimeMillis()));
        info.setFlag(1);
        User user=(User)session.getAttribute("user");
        int userid=user.getId();
        if(uservice.getInfo_num(userid)>0){
            uservice.updatenum(userid);
            info.setUserid(userid);
            if(service.addInfo(info)>0){
                session.setAttribute("error","添加成功");
            }else{
                session.setAttribute("error","添加失败");
            }
        }else{
            session.setAttribute("error","您的发布次数已用尽，请升级为高级会员");
        }
        return "info_post";
    }

    @RequestMapping("/del/{id}")
    public String delete(@PathVariable("id")String id){
        service.delInfo(Integer.parseInt(id));
        return "redirect:/info/manage/0/0";
    }

    @RequestMapping("/stick/{id}")
    public String stick(@PathVariable("id")String id,HttpSession session){
        service.stick(Integer.parseInt(id),session);
        return "redirect:/info/manage/0/0";
    }


}
