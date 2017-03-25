package com.example.service;

import com.example.mapper.UserMapper;
import com.example.mapper.VisitorMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by 王培培 on 2017/2/12.
 */
@Service
public class UserService {
//    @Autowired
//    private VisitorMapper visitorMapper;
//    public int Num(){
//        return visitorMapper.number();
//    }
//    public int new_num(int num){
//        return visitorMapper.new_num(num);
//    }

    @Autowired
    private UserMapper mapper;

    public int saveinfo(User user){
        return mapper.saveinfo(user);
    }
    public int register(User user){
        return mapper.register(user);
    }
    public User selectByPrimaryKey(int userid){
        return mapper.selectByPrimaryKey(userid);
    }
    public User login(Map map){

        return mapper.login(map);
    }

    public int updatefile(User user){
        return mapper.updateByPrimaryKeySelective(user);
    }

    public int updatenum(int id){
        User user=mapper.selectByPrimaryKey(id);
        user.setInfoNum(user.getInfoNum()-1);
        return mapper.updateByPrimaryKeySelective(user);
    }

    public int getInfo_num(int id){
        User user=mapper.selectByPrimaryKey(id);
        int info_num=user.getInfoNum();
        return info_num;
    }

}
