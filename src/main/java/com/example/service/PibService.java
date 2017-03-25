package com.example.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王培培 on 2017/2/28.
 */
public class PibService {
    private Map<String,String> types=new HashMap<String,String>();
    private File saveDir;//上传文件时保存头像的路径
    private File tmpDir;//上传文件临时存储路径
    public PibService(){
        types.put("image/jpeg",".jpg");
        types.put("image/gif",".gif");
        types.put("image/x-ms-bmp",".bmp");
        types.put("image/png",".png");
        tmpDir=new File(System.getProperty("file.separator")+"tmp");//构造器中进行实例化

        if(tmpDir.isDirectory()){//File既包含文件又包含目录 所以要判断是否有目录
            tmpDir.mkdir();//如果没有目录，要进行创建目录
        }
        //hashMap的优点是快速定位，时间复杂度为O(1);
        //top-N 相当于堆排序 大顶堆，小顶堆
        //链表的优点是 增和删    改要先用hashMap定位
    }
}
