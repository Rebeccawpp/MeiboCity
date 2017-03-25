package com.example.service;

import com.example.mapper.InfoMapper;
import com.example.model.Info;
import com.example.model.InfoExample;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王培培 on 2017/2/21.
 */
@Service
public class InfoService {
    @Autowired
    private InfoMapper mapper;

    public List<Info> select(String val){
        InfoExample example=new InfoExample();
        InfoExample.Criteria criteria=example.createCriteria();
        criteria.andTitleLike("%"+val+"%");
        return mapper.selectByExample(example);
    }

    public int count(int f){
        InfoExample example=new InfoExample();
        InfoExample.Criteria criteria=example.createCriteria();
        criteria.andIdIsNotNull();
        criteria.andFlagEqualTo(f);
        return mapper.countByExample(example);
    }

    public List<Info> selectIndexNotice(){//首页的商城公告  限制8个（改   会员置顶）
        InfoExample example=new InfoExample();
        InfoExample.Criteria criteria=example.createCriteria();
        criteria.andFlagEqualTo(0);
        example.setOrderByClause("info_date desc limit 8");
        return mapper.selectByExample(example);
    }

    public void select(String page, String flag, HttpSession session){
        User user=(User)session.getAttribute("user");
        List<Info> n_infos=(List<Info>)session.getAttribute("n_infos");
        List<Info> e_infos=(List<Info>)session.getAttribute("e_infos");
        int cur_page=Integer.parseInt(page);
        int cur_flag=Integer.parseInt(flag);
        Map map1=new HashMap();
        Map map2=new HashMap();
        if(cur_page==0){

            map1.put("userid",user.getId());
            map1.put("curpage",1);
            map1.put("flag",0);
            n_infos=mapper.select(map1);


            map2.put("userid",user.getId());
            map2.put("curpage",1);
            map2.put("flag",1);
            e_infos=mapper.select(map2);
            for(int i=0;i<e_infos.size();i++){
                String oldcontent=e_infos.get(i).getContent();
                if(oldcontent.length()>160){
                    String newcontent=oldcontent.substring(0,160)+"...";
                    e_infos.get(i).setContent(newcontent);
                }
            }
        }else{
            Map map=new HashMap();
            map.put("userid",user.getId());
            map.put("curpage",cur_page);
            map.put("flag",cur_flag);

            if(cur_flag==1){
                e_infos=mapper.select(map);
                for(int i=0;i<e_infos.size();i++){
                    String oldcontent=e_infos.get(i).getContent();
                    if(oldcontent.length()>160){
                        String newcontent=oldcontent.substring(0,160)+"...";
                        e_infos.get(i).setContent(newcontent);
                    }
                }
            }else{
                n_infos=mapper.select(map);
            }
        }

        session.setAttribute("n_infos",n_infos);
        session.setAttribute("e_infos",e_infos);
    }



    public List<Info> select_all_empl(){//所有招聘信息
        InfoExample example1=new InfoExample();
        InfoExample.Criteria criteria1=example1.createCriteria();
        criteria1.andFlagEqualTo(1);
        criteria1.andStickEqualTo(1);
        List<Info> list1=mapper.selectByExample(example1);
        for(int i=0;i<list1.size();i++){
            long time=new Date(System.currentTimeMillis()).getTime()-
                    list1.get(i).getInfoDate().getTime();

            if(time>604800000){
                list1.get(i).setStick(0);
            }
        }
        InfoExample example2=new InfoExample();
        InfoExample.Criteria criteria2=example2.createCriteria();
        criteria2.andFlagEqualTo(1);
        criteria2.andStickEqualTo(0);
        List<Info> list2=mapper.selectByExample(example2);

        list1.addAll(list2);

        for(int i=0;i<list1.size();i++){
            String oldcontent=list1.get(i).getContent();
            if(oldcontent.length()>300){
                String newcontent=oldcontent.substring(0,300)+"...";
                list1.get(i).setContent(newcontent);
            }
        }
        return list1;
    }

    public List<Info> select_all_notice(){//所有商城公告
        InfoExample example1=new InfoExample();
        InfoExample.Criteria criteria1=example1.createCriteria();
        criteria1.andFlagEqualTo(0);
        criteria1.andStickEqualTo(1);
        List<Info> list1=mapper.selectByExample(example1);
        for(int i=0;i<list1.size();i++){
            long time=new Date(System.currentTimeMillis()).getTime()-
            list1.get(i).getInfoDate().getTime();

            if(time>604800000){
                list1.get(i).setStick(0);
            }
        }
        InfoExample example2=new InfoExample();
        InfoExample.Criteria criteria2=example2.createCriteria();
        criteria2.andFlagEqualTo(0);
        criteria2.andStickEqualTo(0);
        List<Info> list2=mapper.selectByExample(example2);

        list1.addAll(list2);
        return list1;
    }
    public Info select_info(int id){
        return mapper.selectByPrimaryKey(id);
    }

    public int addInfo(Info info){
        return mapper.insert(info);
    }

    public int delInfo(int id){
        return mapper.deleteByPrimaryKey(id);
    }

    public void stick(int id,HttpSession session){
        Info info=mapper.selectByPrimaryKey(id);
        InfoExample example=new InfoExample();
        InfoExample.Criteria criteria=example.createCriteria();
        criteria.andStickEqualTo(1);
        criteria.andFlagEqualTo(info.getFlag());
        int stick_num=mapper.countByExample(example);
        if(stick_num>5){
            session.setAttribute("stick_error","当前置顶条数已满，请稍后重试");
        }else{
            info=mapper.selectByPrimaryKey(id);
            info.setStick(1);
            mapper.updateByPrimaryKey(info);
        }
    }
}
