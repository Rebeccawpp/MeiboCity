package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.model.*;
import com.example.service.InfoService;
import com.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 王培培 on 2017/2/11.
 */
@Controller
public class indexController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private InfoService service;
    @RequestMapping("/")
    public String index(HttpSession session,Map map){//首页


//        int number=shopService.number();//总访问次数
//        String s=String.valueOf(number);
//        int []n=new int[s.length()];
//        for(int i=0;i<s.length();i++){
//            n[i] =Integer.parseInt(s.substring(i,i+1));
//        }
//        map.put("visitor",n);
//        session.setAttribute("number",number);
        List<Type1> list=shopService.query();
        map.put("tlist",list);

        List<Shop> list1=shopService.selectAll();
        map.put("slist",list1);
        List <Product> list2= shopService.init1();
        map.put("inilist",list2);
        List <Product> list3= shopService.init3();
        map.put("inilist3",list3);
        List <Product> list4= shopService.init4();
        map.put("inilist4",list4);
        List <Product> list5= shopService.init5();
        map.put("inilist5",list5);
        List <Product> list6= shopService.init6();
        map.put("inilist6",list6);
        List<Info> infos=service.selectIndexNotice();
        session.setAttribute("infos",infos);

        session.setAttribute("base","http://localhost:8080");
        return "index";
    }
    @RequestMapping("/register")//注册
    public String register(){//登录
        return "register";
    }

    @RequestMapping("/login")//登录
    public String login(){//注册
        return "login";
    }

    @RequestMapping("/shop")         //商铺管理
    public String shop(){//我的商铺
        return "shop";
    }
    @RequestMapping("/yuming")       //商铺管理---域名设置
    public String yuming(){ return "yuming";}
    @RequestMapping("/fabushangpin")//商铺管理---发布商品
    public String fabushangpin(){ return "fabushangpin";}
    @RequestMapping("/dianpushezhi")//商铺管理---店铺设置
    public String dianpushezhi(){ return "dianpushezhi";}
    @RequestMapping("/maijiazhongxin")//商铺管理---卖家中心
    public String maijiazhongxin(){ return "maijiazhongxin";}
    @RequestMapping("/chanpinfenlei")//商铺管理---产品分类
    public String chanpinfenlei(){ return "chanpinfenlei";}
    @RequestMapping("/fahuo")        //商铺管理---发货
    public String fahuo(){ return "fahuo";}
    @RequestMapping("/maichushangpin")//商铺管理---已卖出商品
    public String maichushangpin(){ return "maichushangpin";}
    @RequestMapping("/jikuaidi")//商铺管理---寄快递
    public String jikuaidi(){ return "jikuaidi";}
    @RequestMapping("/quanxian")//商铺管理---权限
    public String quanxian(){ return "quanxian";}

    @RequestMapping("/brand")   //品牌搜索 ---产品列表
    public String brand(){ return "brand";}

    @RequestMapping("/payfor")//产品详情页
    public String payfor(){ return "payfor";}

    @RequestMapping("/store")   //店铺主页
    public String store(){ return "store";}

    @RequestMapping("/store1")  //产品详情页
    public String store1(){ return "store1";}

    @RequestMapping("/banzhu")  //用户帮助中心
    public String banzhu(){ return "banzhu";}

    @RequestMapping("/fenleiliebiao")//分类列表
    public String feileiliebiao(){ return "fenleiliebiao";}

    @RequestMapping("/oto-about")//关于我们
    public String otoabout(){ return "oto-about";}

    @RequestMapping("/pingjia")       //用户管理中心-我的评价
    public String pingjia(){ return "pingjia";}
    @RequestMapping("/oto-help")      //用户管理中心-常见问题查询
    public String otohelp(){ return "oto-help";}

    @RequestMapping("/tousu")          //用户管理中心-在线投诉
    public String tousu(){ return "tousu";}

    @RequestMapping("/tuihuan")        //用户管理中心-在线退换货物
    public String tuihuan(){ return "tuihuan";}
    @RequestMapping("/shopcar")       //用户管理中心-我的订单
    public String shopcar(){ return "shopcar";}
    @RequestMapping("/user")           //用户管理中心-我的订单
    public String user(){ return "user";}
    @RequestMapping("/order")         //用户管理中心-我的订单
    public String order(){ return "order";}
    @RequestMapping("/user_message")  //用户管理中心-编辑资料
    public String user_message(){ return "user_message";}
    @RequestMapping("/bianjiziliao")  //用户管理中心-编辑资料
    public String bianjiziliao(){ return "bianjiziliao";}
    @RequestMapping("/manage")        //用户管理中心-编辑资料
    public String manage(){//用户管理
        return "manage";
    }
    @RequestMapping("/maijiazhongxin(buy)")//用户管理中心-编辑资料
    public String maijiazhongxin1(){ return "maijiazhongxin(buy)";}
    @RequestMapping("/shoucang")      //用户管理中心-我的收藏
    public String shoucang(){ return "shoucang";}
    @RequestMapping("/xiaoxitixing")  //用户管理中心-消息提醒
    public String xiaoxitixing(){ return "xiaoxitixing";}
    @RequestMapping("/yigou")          //用户管理中心-已购商品
    public String yigou(){ return "yigou";}
    @RequestMapping("/zhanghu")        //用户管理中心-账户查询
    public String zhanghu(){ return "zhanghu";}
    @RequestMapping("/tianxiedingdanxinxi")//用户管理中心-我的订单 填写订单信息
    public String tianxie(){
        return "tianxiedingdanxinxi";
    }
    @RequestMapping("/saveinfo")//保存用户信息
    public String save(){
        return "saveinfo";
    }

    @RequestMapping("/new")
    public String new1(){
        return "new";
    }

    @RequestMapping("test/{val}")
    @ResponseBody
    public String select(@PathVariable("val")String val){
        List<Result> list1=new ArrayList<Result>();
            List<Product> list=shopService.select(val);

            for(int i=0;i<list.size();i++){
                String info = list.get(i).getName();
                list1.add(new Result(info,info));
            }

        String json= JSON.toJSONString(list1,true);
        return json;
    }
}
