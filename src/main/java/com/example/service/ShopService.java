package com.example.service;

import com.example.mapper.*;
import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 王培培 on 2017/2/23.
 */
@Service
public class ShopService {
    @Autowired
    private Type1Mapper type1Mapper;

    public List<Type1> query(){
        return type1Mapper.query();
    }

    @Autowired
    private ProductMapper productMapper;
    public Product buy(int id){
        return productMapper.selectByPrimaryKey(id);//根据商品id 查看商品名字和价格
    }
    public Product queryShopid(int productid){//查询店铺id
        return productMapper.selectByPrimaryKey(productid);
    }
    public int insert(Product record){
        return productMapper.insert(record);
    }
    public List<Product> init1(){//爆品疯抢
        return productMapper.init(1);
    }
    public List<Product> init3(){//爆品疯抢
        return productMapper.init(2);
    }
    public List<Product> init4(){//爆品疯抢
        return productMapper.init(3);
    }
    public List<Product> init5(){//爆品疯抢
        return productMapper.init(4);
    }
    public List<Product> init6(){//爆品疯抢
        return productMapper.init(5);
    }
    public List<Product> more(int typeid){ return productMapper.more(typeid);}
    public List<Product> hotShop(){ return productMapper.hotShop();}
    public List<Product> all_pro(Map map){ return productMapper.all_pro(map);}//存储过程查询所有类型商品
    public int quantity(int typeid){
        return productMapper.quantity(typeid);//查询结果总数
    }
    public List<Product> select(String val){
        ProductExample productExample=new ProductExample();
        ProductExample.Criteria criteria=productExample.createCriteria();
        criteria.andNameLike("%"+val+"%");
        return productMapper.selectByExample(productExample);
    }
    public List<Product> products(int shopid){
        return productMapper.selectByShopid(shopid);
    }
    public int queryId(String name){
        if( productMapper.queryId(name)!=null){
            return productMapper.queryId(name);
        }else{
            return 0;
        }
    }
//    public int total(int shopid){
//        return productMapper.total(shopid);
//    }

    @Autowired
    private OrdersMapper ordersMapper;
    public void addOrders(Orders orders){
        ordersMapper.insert(orders);//将购买数据存入orders表中
    }
    public int selectId(){
        return ordersMapper.selectId();
    }
    public int queryId(int userid){
        return ordersMapper.queryId(userid);
    }

    @Autowired
    private ItemMapper itemMapper;
    public int addItem(Item item){
        return itemMapper.insert(item);
    }
    public List<Item> queryAll1(int orderid){
        return itemMapper.queryAll(orderid);
    }


    @Autowired
    private CartMapper cartMapper;
    public int addCart(Cart cart){
        return cartMapper.insert(cart);
    }
    public List<Cart> queryAll(int userid){
        return cartMapper.queryAll(userid);
    }

    @Autowired
    private Type2Mapper type2Mapper;
    public List<String> queryType(){
        return type2Mapper.queryType();
    }
    public List<Type2> selectByExample(Type2Example type2){
        return type2Mapper.selectByExample(type2);
    }
    public List<Type2> selectByKey(int firstid){return type2Mapper.selectByKey(firstid);}

    @Autowired
    private ShopMapper shopMapper;
    public int selectId(int userid){
        return shopMapper.selectId(userid);
    }
    public List<Shop> selectAll(){
        return shopMapper.selectAll();
    }
    public Shop selectByPrimaryKey(int shopid){
        return shopMapper.selectByPrimaryKey(shopid);
    }
    public Shop exit(int userid){
        return shopMapper.selectByUserId(userid);
    }

    @Autowired
    private VisitorMapper visitorMapper;
    public int number(){
        return visitorMapper.number();
    }
}
