package com.example.controller;

import com.example.mapper.ShopMapper;
import com.example.model.*;
import com.example.service.ShopService;
import com.example.service.UserService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static org.apache.tomcat.jni.Time.now;

/**
 * Created by 王培培 on 2017/2/23.
 */
@Controller
@RequestMapping("shoping")
public class ShopController {
    @Autowired
    private ShopService shopservice;
    @Autowired
    private UserService userservice;

    @RequestMapping("/stopro/proid/{product_id}")//查看店铺商品详情
    public String stopro(@PathVariable("product_id")int product_id,HttpSession session){
        Product p1=shopservice.buy(product_id);
        session.setAttribute("stopro",p1);
        return "store1";
    }

    @RequestMapping("/looking")//搜索框
    public String look(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        String name=request.getParameter("search");
        System.out.println(name);
        if(shopservice.queryId(name)>0){
            int pro_id=shopservice.queryId(name);
            Product p=shopservice.buy(pro_id);//根据商品id查看该商品全部信息
            session.setAttribute("enty",p);
            return "payfor";
        }else{
            return "redirect:/";
        }

    }


    @RequestMapping("/exit")
    public String exit(HttpSession session,Map map){//查看店铺
        User user1=(User)session.getAttribute("user");
        if(user1==null){
            return "login";
        }else{
            int userid=user1.getId();
            Shop shop=shopservice.exit(userid);
            if(shop!=null){
                int shopid=shop.getId();
                Shop shop1=shopservice.selectByPrimaryKey(shopid);//通过商店id查询商店所有信息
                session.setAttribute("shop",shop1);
                List <Product> products=shopservice.products(shopid);//商店所有商品
                map.put("products",products);
                return "store";
            }else{
                return "shop";
            }
        }
    }

    @RequestMapping("/item/init_id/{init_id}")
    public String item(@PathVariable("init_id")int init_id,HttpSession session){
        Product p=shopservice.buy(init_id);
        session.setAttribute("enty",p);
        return "payfor";
    }
    @RequestMapping("/store/shopid/{shopid}")
    public String store(@PathVariable("shopid")int shopid,Map map,HttpSession session){
        //System.out.println("ok");
        Shop shop=shopservice.selectByPrimaryKey(shopid);//通过商店id查询商店所有信息
        session.setAttribute("shop",shop);
        List <Product> products=shopservice.products(shopid);//商店所有商品
        map.put("products",products);
//        int total=shopservice.total(shopid);
//        int floor=0;
//        if(total%5==0){
//            floor=total/5;
//        }else{
//            floor=total/5+1;
//        }
//        session.setAttribute("floor",floor);
        return "store";
    }


    @RequestMapping("/more/type1_id/{type_id}/{curpage}")//产品种类搜索所有产品
    public String more( @PathVariable("type_id")int type_id,@PathVariable("curpage")int curpage, ModelMap map1,HttpSession session){
        List <Type2> list=shopservice.selectByKey(type_id);//根据种类id 找出所有的type2
       // Iterator <Type2>iterator=list.iterator();
       // List<Product> All=new ArrayList<>();
       // int type2_id=iterator.next().getId();//对应的type2的id  有多个值
        session.setAttribute("type_id",type_id);
        int  quantity=shopservice.quantity(type_id);//符合type的所有商品总数量
        int page=0;
        if(quantity%10==0){
            page=quantity/10;
        }else{
            page=quantity/10+1;//分页总数
        }
        session.setAttribute("page",page);
            //List<Product> list1= shopservice.more(type2_id);
            Map map=new HashMap();
            map.put("curpage",curpage);
            map.put("typeid",type_id);
            List<Product> listPro=shopservice.all_pro(map);//对应所有产品信息的查询

        map1.put("more",listPro);
        List<Product> hotShop=shopservice.hotShop();
        map1.put("hotShop",hotShop);
        return "brand";
    }

    @RequestMapping("/search")//搜索栏
    public String search(HttpServletRequest request,HttpSession session){

        return "";
    }

    @RequestMapping("/order1")//我的订单
    public  String order(HttpSession session,Map map){
        //将购物车中的商品遍历出来
        User user1=(User)session.getAttribute("user");
        int userid=user1.getId();
        List <Cart> list=shopservice.queryAll(userid);
        map.put("clist",list);
        return "order";
    }
    @RequestMapping("/display")//立即购买商品显示
    public String display(HttpSession session,Map map){
        User user1=(User)session.getAttribute("user");
        int userid=user1.getId();
        int id=shopservice.queryId(userid);//orders 中的主键id
        List<Item>list= shopservice.queryAll1(id);
        map.put("ilist",list);
        return "shopcar";
    }

    @RequestMapping("/publish")//发布商品
    public String publish(@ModelAttribute("product")Product product, HttpSession session,  HttpServletRequest request){
        Product product1=new Product();
        User user1=(User)session.getAttribute("user");
        int userid=user1.getId();
        //通过用户id找出对应的shopid
        int shopid=shopservice.selectId(userid);
        String dir="";
//        product1.setName(request.getParameter("name"));
//        product1.setPrice(Double.parseDouble(request.getParameter("price")));
//        product1.setStock(Integer.parseInt(request.getParameter("stock")));
//        product1.setIntro(request.getParameter("intro"));
        //String pibPath=request.getParameter("pibPath");
        //System.out.println(pibPath);
        //product1.setPib(pib.getBytes());
       // product1.setTypeid(Integer.parseInt(request.getParameter("typeid")));
        //String path=request.getSession().getServletContext().getRealPath("/resources/Pic");
       // String path= request.getServletContext().getRealPath("");

            //String path=this.getClass().getResource("/").toString();
        String path="H:\\MeiboCity\\src\\main\\resources\\static";//该路径为项目所在路径
        try {
            Part p=request.getPart("pibPath");
          //  path=path.substring(6);
            String h=p.getHeader("content-disposition");
            String name=p.getSubmittedFileName();
            System.out.println("##"+h);
            System.out.println("####"+name);
            //System.out.println(path) ;
            path=path+"\\Pic";
            File f=new File(path);
            if(!f.exists()){
                f.mkdir();
            }
            p.write(path+"\\"+name);
            dir="Pic\\"+name;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        product.setPib(dir);
        product.setShopid(shopid);
        product.setFlag(0);
        product.setClick(0);
        product.setAttr(0);
        shopservice.insert(product);
        System.out.println("图片路径"+product.getPib());
        return "shop";
      //  return "";
    }

    @RequestMapping("/type")
    public List<String> queryType(){
        return shopservice.queryType();
    }

    @RequestMapping("/add")//加入购物车
    public String add(@ModelAttribute("product")Product product, HttpSession session, HttpServletRequest request,Map map){

        User user1=(User)session.getAttribute("user");
        if(user1==null){
            return "login";
        }else {
            Cart cart = new Cart();
            int userid = user1.getId();
            String id = request.getParameter("id");
            String number = request.getParameter("number");
            cart.setUserid(userid);
            cart.setProductid(Integer.parseInt(id));
            cart.setNum(Integer.parseInt(number));
            cart.setTime(new Date());

            Product product2 = shopservice.queryShopid(Integer.parseInt(id));
            int shopid = product2.getShopid();
            cart.setShopid(shopid);
            if (shopservice.addCart(cart) > 0) {
                List <Cart> list=shopservice.queryAll(userid);
                map.put("clist",list);
             //   session.setAttribute("clist",list);
                return "order";
            }
        }
       return "payfor";
    }

    @RequestMapping("/buy")//立即购买
    public String buy(@ModelAttribute("product")Product product, HttpSession session, HttpServletRequest request){

        User user1=(User)session.getAttribute("user");
        if(user1==null){
            return "login";
        }else{//需要在数据库中找出 对应商品的 价格和 名称
        int userid=user1.getId();
        User user_info= userservice.selectByPrimaryKey(userid);//购物者的所有信息
        session.setAttribute("user_info",user_info);
        Orders orders=new Orders();
        orders.setUserid(userid);
        String number=request.getParameter("number");
        String id=request.getParameter("id");
        Item item=new Item();
        item.setNum(Integer.parseInt(number));//订单的数量
        item.setProid(Integer.parseInt(id));//商品id号

            Product product2= shopservice.buy(Integer.parseInt(id));
            double price=product2.getPrice();
            String name=product2.getName();
            orders.setOrderDate(new Date());
            orders.setTotal( price * Integer.parseInt(number));//订单总价
            shopservice.addOrders(orders);
            int orderid=shopservice.selectId();
            item.setOrderid(orderid);
            item.setShopname(name);
            item.setPrice(price);
            session.setAttribute("item",item);
            shopservice.addItem(item);
        }
        return "shopcar";
    }
}
