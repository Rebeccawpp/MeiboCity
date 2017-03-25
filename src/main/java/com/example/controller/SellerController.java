package com.example.controller;

import com.example.model.Type2;
import com.example.model.Type2Example;
import com.example.service.SellerService;
import com.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by 王培培 on 2017/2/28.
 */
@Controller
public class SellerController {//卖家中心
    @Autowired
    private ShopService shopService;
    @RequestMapping("/fabu")
    public String ok(Map map){
        Type2Example example=new Type2Example();
        example.createCriteria().andIdIsNotNull();
        List<Type2> list=shopService.selectByExample(example);
        map.put("tlist",list);//商品类型
        return "fabushangpin";
    }
}
